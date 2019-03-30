package za.co.reference.ejb3.entity;

public enum SampleEnumeration{
	
	ONE("1"),
	TWO("2"),
	THREE("3");
	
	SampleEnumeration(String number){
		this.number = number;
	}
	
	public String getNumber(){
		return number;
	}

	public void setNumber(String number){
		this.number = number;
	}

	private String number;

}
