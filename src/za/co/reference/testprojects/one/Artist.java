package za.co.reference.testprojects.one;

public class Artist{
	
	public Artist(){
		
	}
	
	public Artist(String name){
		this.name = name;
	}
	
	public Artist(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	private int id;
	private String name;

}
