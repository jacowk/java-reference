package za.co.reference.ejb2.bmp;

public class AccountException extends Exception{
	
	public AccountException(){
		super();
	}
	
	public AccountException(Exception e){
		super(e.toString());
	}
	
	public AccountException(String str){
		super(str);
	}

}
