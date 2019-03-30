package za.co.reference.ejb2.bmp;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AccountBean implements EntityBean{

	public AccountBean(){
		System.out.println("New AccountBean created by EJB Container");
	}
	
	public void deposit(double amt){
		System.out.println("deposit(" + amt + ") called");
		balance += amt;
	}
	
	public void withdraw(double amt){
		System.out.println("withdraw(" + amt + ") called");
		if (amt > balance){
//			throw new AccountException("Your balance is " + balance + "! You cannot withdraw " + amt + "!");
		}
		balance -= amt;
	}
	
	public EntityContext getCtx(){
		return ctx;
	}

	public void setCtx(EntityContext ctx){
		this.ctx = ctx;
	}

	public String getAccountID(){
		return accountID;
	}

	public void setAccountID(String accountID){
		this.accountID = accountID;
	}

	public String getOwnerName(){
		return ownerName;
	}

	public void setOwnerName(String ownerName){
		this.ownerName = ownerName;
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}
	
	public double ejbHomeGetTotalBankValue() throws AccountException{
		PreparedStatement pstmt = null;
		Connection conn = null;
		try{
			System.out.println("ejbHomeGetTotalBankValue");
			conn = getConnection();
			pstmt = conn.prepareStatement("select sum(balance) as total from accounts");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				return rs.getDouble("total");
			}
		}
		catch (Exception e){
			e.printStackTrace();
			throw new AccountException(e);
		}
		finally{
			try{
				if (pstmt != null) pstmt.close();
			}
			catch (Exception e){
				
			}
			try{
				if (conn != null) conn.close();
			}
			catch (Exception e){
				
			}
		}
		throw new AccountException("Error!");
	}
	
	public Connection getConnection(){
		try{
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ejbPool");
			return ds.getConnection();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException{
		System.out.println("ejbActivate called");
	}

	@Override
	public void ejbLoad() throws EJBException, RemoteException{
		System.out.println("ejbLoad called");
		AccountPK pk = (AccountPK)ctx.getPrimaryKey();
		String id = pk.accountID;
		PreparedStatement pstmt = null;
		Connection connection = null;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement("select ownerName, balance from accounts where id = ?");
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			ownerName = rs.getString("ownerName");
			balance = rs.getDouble("balance");
		}
		catch (Exception e){
			throw new EJBException("Account " + pk + " failed to load from database", e);
		}
		finally{
			try{
				if (pstmt != null) pstmt.close();
			}
			catch (Exception e){
				
			}
			try{
				if (connection != null) connection.close();
			}
			catch (Exception e){
				
			}
		}
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException{
		System.out.println("ejbPassivate called");
	}

	@Override
	public void ejbRemove() throws RemoveException, EJBException, RemoteException{
		System.out.println("ejbRemove called");
		AccountPK pk = (AccountPK)ctx.getPrimaryKey();
		String id = pk.accountID;
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from accounts where id = ?");
			pstmt.setString(1, id);
			if (pstmt.executeUpdate() == 0){
				throw new RemoveException("Account " + pk + " failed to be removed from the database");
			}
		}
		catch (Exception e){
			throw new EJBException(e.toString());
		}
		finally{
			try{
				if (pstmt != null) pstmt.close();
			}
			catch (Exception e){
				
			}
			try{
				if (conn != null) conn.close();
			}
			catch (Exception e){
				
			}
		}
	}

	@Override
	public void ejbStore() throws EJBException, RemoteException{
		System.out.println("ejbStore called");
		PreparedStatement pstmt = null;
		Connection connection = null;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement("update accounts set ownerName = ?, balance = ? where id = ?");
			pstmt.setString(1, ownerName);
			pstmt.setDouble(2, balance);
			pstmt.setString(3, accountID);
			pstmt.executeUpdate();
		}
		catch (Exception e){
			throw new EJBException("Account " + accountID + " failed to save to database");
		}
		finally{
			try{
				if (pstmt != null) pstmt.close();
			}
			catch (Exception e){
				
			}
			try{
				if (connection != null) connection.close();
			}
			catch (Exception e){
				
			}
		}
	}

	@Override
	public void setEntityContext(EntityContext ctx) throws EJBException, RemoteException{
		System.out.println("setEntityContext called");
		this.ctx = ctx;
	}

	@Override
	public void unsetEntityContext() throws EJBException, RemoteException{
		System.out.println("unsetEntityContext called");
		this.ctx = null;
	}
	
	public void ejbPostCreate(String accountID, String ownerName) throws CreateException{
		
	}
	
	public AccountPK ejbCreate(String accountID, String ownerName) throws CreateException{
		PreparedStatement pstmt = null;
		Connection conn = null;
		try{
			System.out.println("ejbCreate() called");
			this.accountID = accountID;
			this.ownerName = ownerName;
			this.balance = 0;
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into accounts(id, ownerName, balance) " +
				"values(?, ?, ?)");
			pstmt.setString(1, accountID);
			pstmt.setString(2, ownerName);
			pstmt.setDouble(3, balance);
			pstmt.executeUpdate();
			return new AccountPK(accountID);
		}
		catch (Exception e){
			
		}
		finally{
			try{
				if (pstmt != null) pstmt.close();
			}
			catch (Exception e){
				
			}
			try{
				if (conn != null) conn.close();
			}
			catch (Exception e){
				
			}
		}
		return null;
	}
	
	public AccountPK ejbFindByPrimaryKey(AccountPK key) throws FinderException{
		PreparedStatement pstmt = null;
		Connection conn = null;
		try{
			System.out.println("ejbFindByPrimaryKey(" + key + ") called");
			conn = getConnection();
			pstmt = conn.prepareStatement("select id from accounts where id = ?");
			pstmt.setString(1, key.toString());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return key;
		}
		catch (Exception e){
			
		}
		finally{
			try{
				if (pstmt != null) pstmt.close();
			}
			catch (Exception e){
				
			}
			try{
				if (conn != null) conn.close();
			}
			catch (Exception e){
				
			}
		}
		return null;
	}
	
	public Collection ejbFindByOwnerName(String name) throws FinderException{
		PreparedStatement pstmt = null;
		Connection conn = null;
		Vector v = new Vector();
		try{
			System.out.println("ejbFindByOwnerName(" + name + ") called");
			conn = getConnection();
			pstmt = conn.prepareStatement("select id from accounts where ownerName = ?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				String id = rs.getString("id");
				v.add(id);
			}
			return v;
		}
		catch (Exception e){
			
		}
		finally{
			try{
				if (pstmt != null) pstmt.close();
			}
			catch (Exception e){
				
			}
			try{
				if (conn != null) conn.close();
			}
			catch (Exception e){
				
			}
		}
		return null;
	}
	
	protected EntityContext ctx;
	private String accountID;
	private String ownerName;
	private double balance;
	

}
