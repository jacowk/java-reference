package za.co.reference.designpatterns.behavioralpatterns.command;

public class Switch{
	
	public Switch(Command flipUpCmd, Command flipDownCmd){
		this.flipUpCommand = flipUpCmd;
		this.flipDownCommand = flipDownCmd;
	}
	
	public void flipUp(){
		flipUpCommand.execute();
	}
	
	public void flipDown(){
		flipDownCommand.execute();
	}
	
	private Command flipUpCommand;
	private Command flipDownCommand;

}
