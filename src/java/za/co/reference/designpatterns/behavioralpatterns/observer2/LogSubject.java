package za.co.reference.designpatterns.behavioralpatterns.observer2;

import java.util.ArrayList;
import java.util.List;

public class LogSubject{
	
	public void attach(IObserver iobserver){
		observerList.add(iobserver);
	}
	
	public void detach(IObserver iobserver){
		observerList.remove(iobserver);
	}
	
	public void stateChanged(){
		for (IObserver iobserver: observerList){
			iobserver.update(getState());
		}
	}
	
	public List<IObserver> getObserverList(){
		return observerList;
	}
	
	public void setObserverList(List<IObserver> observerList){
		this.observerList = observerList;
	}
	
	public String getState(){
		return state;
	}
	
	public void setState(String state){
		this.state = state;
		stateChanged();
	}
	
	private List<IObserver> observerList = new ArrayList<IObserver>();
	private String state;

}
