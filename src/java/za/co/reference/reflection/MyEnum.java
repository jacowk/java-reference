package za.co.reference.reflection;

public enum MyEnum{
	
	ONE("One"),
	TWO("Two"),
	Three("Three");
	
	MyEnum(String value){
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