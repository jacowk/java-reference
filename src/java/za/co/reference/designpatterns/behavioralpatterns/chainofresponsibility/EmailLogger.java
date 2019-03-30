package za.co.reference.designpatterns.behavioralpatterns.chainofresponsibility;

public class EmailLogger extends Logger{

	public EmailLogger(int mask){
		this.mask = mask;
	}
	
	@Override
	protected void writeMessage(String msg){
		System.out.println("Sending to email: " + msg);
	}

}
