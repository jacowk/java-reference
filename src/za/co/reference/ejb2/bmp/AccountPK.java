package za.co.reference.ejb2.bmp;

import java.io.Serializable;

public class AccountPK implements Serializable{
	
	public AccountPK(String id){
		this.accountID = id;
	}
	
	public AccountPK(){
		
	}
	
	public String toString(){
		return accountID;
	}
	
	public int hashCode(){
		return accountID.hashCode();
	}
	
	public boolean equals(Object account){
		if (!(account instanceof AccountPK)){
			return false;
		}
		return ((AccountPK)account).accountID.equals(accountID);
	}
	
	public String accountID;

}
