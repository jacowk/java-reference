package za.co.reference.designpatterns.behavioralpatterns.chainofresponsibility;

public class StderrLogger extends Logger{

	public StderrLogger(int mask){
		this.mask = mask;
	}
	
	@Override
	public void writeMessage(String msg){
		System.err.println("Sending to stderr: " + msg);
	}
	
}
