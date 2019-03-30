package za.co.reference.transactions.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionWithJDBCExample{

	public static void main(String[] args){
		TransactionWithJDBCExample transactionWithJDBCExample = new TransactionWithJDBCExample();
		try{
			transactionWithJDBCExample.establishConnection();
			transactionWithJDBCExample.performSelect();
			transactionWithJDBCExample.commit();
		}
		catch (Exception e){
			transactionWithJDBCExample.rollback();
			e.printStackTrace();
		}
		finally{
			transactionWithJDBCExample.closeConnection();
		}
	}
	
	private void establishConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/testdb";
		connection = DriverManager.getConnection(url, "username", "password");
		/* 
		 * If setAutoCommit is set to false, all SQL statements are grouped into a transaction, and only
		 * executed when commit() or rollback() is called.
		 *  
		 * */
		connection.setAutoCommit(false);
	}
	
	private void performSelect() throws Exception{
		String query = "select firstname, surname from user where username like '?' and password like '?';";
		PreparedStatement selectStatement = connection.prepareStatement(query);
		selectStatement.setString(1, "username");
		selectStatement.setString(2, "password");
		ResultSet selectResultSet = selectStatement.executeQuery();
		while (selectResultSet.next()){
			selectResultSet.getString("firstname");
			selectResultSet.getString("surname");
		}
	}
	
	private void commit(){
		try{
			connection.commit();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void rollback(){
		try{
			connection.rollback();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	private void closeConnection(){
		try{
			connection.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	private Connection connection;
	
}
