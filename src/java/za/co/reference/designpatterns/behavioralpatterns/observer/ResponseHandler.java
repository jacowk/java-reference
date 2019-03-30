package za.co.reference.designpatterns.behavioralpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class ResponseHandler implements Observer{

	@Override
	public void update(Observable observable, Object object){
		response = (Integer)object;
		System.out.println("Received " + response);
	}
	
	private int response;

}
