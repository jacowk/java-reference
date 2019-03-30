package za.co.reference.designpatterns.behavioralpatterns.command.example2;

import java.util.Stack;

public class Invoker{
	
	  public Invoker(){
		  commands = new Stack<Command>();
	  }
	
	  public void setIncCommand(Command command){
		  incCommand = command;
	  }
	
	  public void setDecCommand(Command command){
		  decCommand = command;
	  }
	
	  public void undoAll(){
		Command cmd = null;
		while (!commands.empty()){
		  cmd = commands.pop();
		  cmd.undo();
		}
	  }
	
	  public void addRequest(){
		incCommand.execute();
		commands.add(incCommand);
	  }
	
	  public void removeRequest(){
		decCommand.execute();
		commands.add(decCommand);
	  }
	
	  public void commit(){
		commands = new Stack<Command>();
	  }
	  
	  private Stack<Command> commands;
	  private Command incCommand;
	  private Command decCommand;
	  
}