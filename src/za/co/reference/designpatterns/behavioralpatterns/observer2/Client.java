package za.co.reference.designpatterns.behavioralpatterns.observer2;

public class Client{
	
	public static void main(String[] args){
		LogSubject logSubject = new LogSubject();
		IObserver ob1 = new Observer1();
		IObserver ob2 = new Observer2();
		IObserver ob3 = new Observer1();
		logSubject.attach(ob1);
		logSubject.attach(ob2);
		logSubject.attach(ob3);
		logSubject.setState("Active");
		logSubject.setState("Resigned");
		logSubject.detach(ob2);
		logSubject.setState("Pending");
	}

}
