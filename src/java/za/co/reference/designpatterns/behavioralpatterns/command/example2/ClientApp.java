package za.co.reference.designpatterns.behavioralpatterns.command.example2;

public class ClientApp{
	
	//http://java-x.blogspot.com/2006/12/implementing-command-pattern-in-java.html
	//http://www.javaworld.com/javatips/jw-javatip68.html
	
	public static void main(String[] args){
		Receiver rec = new Receiver();
		Command incCommand = new IncrementCommand(rec);
		Command decCommand = new DecrementCommand(rec);
		Invoker invoker = new Invoker();
		invoker.setDecCommand(decCommand);
		invoker.setIncCommand(incCommand);
		invoker.addRequest();
		invoker.addRequest();
		invoker.removeRequest();
		System.out.println(rec.getValue());
	}

}