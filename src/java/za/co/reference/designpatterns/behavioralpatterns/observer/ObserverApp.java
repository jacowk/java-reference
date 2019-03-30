package za.co.reference.designpatterns.behavioralpatterns.observer;

public class ObserverApp{
	
	public static void main(String[] args){
		EventSource eventSource = new EventSource();
		ResponseHandler responseHandler = new ResponseHandler();
		eventSource.addObserver(responseHandler);
		Thread thread = new Thread(eventSource);
		thread.start();
	}

}
