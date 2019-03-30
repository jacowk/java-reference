package za.co.reference.testprojects.two.common.button;

public enum ButtonName{
	
	ADD("Add"),
	MODIFY("Modify"),
	DELETE("Delete"),
	VIEW("View"),
	SEARCH("Search"),
	SAVE("Save"),
	CANCEL("Cancel"),
	CLOSE("Close");
	
	ButtonName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	private String name;

}
