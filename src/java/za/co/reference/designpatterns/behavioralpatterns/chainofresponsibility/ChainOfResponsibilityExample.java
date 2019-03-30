package za.co.reference.designpatterns.behavioralpatterns.chainofresponsibility;

public class ChainOfResponsibilityExample{
	
	public static void main(String[] args){
		Logger l,ll;
		ll = l = new StdoutLogger(Logger.DEBUG);
		ll = ll.setNext(new EmailLogger(Logger.NOTICE));
		ll = ll.setNext(new StderrLogger(Logger.ERR));
		
		l.message("Entering function y.", Logger.DEBUG);
		l.message("Step1 completed", Logger.NOTICE);
		l.message("An error has occurred", Logger.ERR);
	}

}
