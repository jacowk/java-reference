package za.co.reference.designpatterns.behavioralpatterns.chainofresponsibility;

public abstract class Logger{
	
	public Logger setNext(Logger l){
		next = l;
		return next;
	}
	
	public void message(String msg, int priority){
		if (priority <= mask){
			writeMessage(msg);
		}
		if (next != null){
			next.message(msg, priority);
		}
	}
	
	protected abstract void writeMessage(String msg);
	
	public static int ERR = 3;
	public static int NOTICE = 5;
	public static int DEBUG = 7;
	protected int mask;
	protected Logger next;

}
