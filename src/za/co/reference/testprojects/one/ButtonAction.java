package za.co.reference.testprojects.one;

public enum ButtonAction{
	
	ADD("Add"),
	DELETE("Delete"),
	MODIFY("Modify"),
	VIEW("View");
	
	ButtonAction(String actionDescription){
		this.actionDescription = actionDescription;
	}
	
	public String getActionDescription(){
		return actionDescription;
	}

	public void setActionDescription(String actionDescription){
		this.actionDescription = actionDescription;
	}

	String actionDescription;
	
}