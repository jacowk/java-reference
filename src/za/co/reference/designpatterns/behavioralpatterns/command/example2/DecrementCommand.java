package za.co.reference.designpatterns.behavioralpatterns.command.example2;

public class DecrementCommand implements Command{
	
	public DecrementCommand(Receiver receiver){
		this.receiver = receiver;    
	}
	  
	public void execute(){
		receiver.decrement();    
	}
	
	public void undo(){
		receiver.increment();
	}
	
	private Receiver receiver;
  
}