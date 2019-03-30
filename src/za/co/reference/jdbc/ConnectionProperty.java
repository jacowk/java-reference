package za.co.reference.jdbc;

public enum ConnectionProperty{

	CONNECTION_URL("connectionURL"),
	DRIVER_CLASS("driverClass"),
	USER("user"),
	PASSWORD("password");

	ConnectionProperty(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	private final String name;
	
}