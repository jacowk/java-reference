package za.co.reference.designpatterns.behavioralpatterns.command.example2;

public class IncrementCommand implements Command{
	  
	  public IncrementCommand(Receiver rec){
	    receiver = rec;
	  }
	
	  public void execute(){
	    receiver.increment();
	
	  }
	
	  public void undo(){
	    receiver.decrement();
	  }
	  
	  private Receiver receiver;

}