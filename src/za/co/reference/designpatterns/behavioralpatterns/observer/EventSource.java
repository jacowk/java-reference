package za.co.reference.designpatterns.behavioralpatterns.observer;

import java.util.Observable;

public class EventSource extends Observable implements Runnable{

	@Override
	public void run(){
		int i = 0;
		while (true){
			i++;
			setChanged();
			notifyObservers(i);
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
