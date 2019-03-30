package za.co.reference.reflection;

public class MyArrayClass{

	public MyArrayClass(){
		
	}
	
	public MyArrayClass(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

	public void setValue(String value){
		this.value = value;
	}

	private String value;
	
}