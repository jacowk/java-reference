package za.co.reference.practice;

import java.util.Observable;
import java.util.Observer;

public class PracticeObserver{
	
	public PracticeObserver(){
		view = new MyView();
		model = new MyModel();
		model.addObserver(view);
	}
	
	public static void main(String[] args){
		PracticeObserver practiceObserver = new PracticeObserver();
		practiceObserver.demo();
	}
	
	private void demo(){
		model.changeSomething();
	}
	
	private class MyView implements Observer{

		@Override
		public void update(Observable observable, Object object){
			System.out.println("update(" + observable + ", " + object + ");");
		}
		
	}
	
	private class MyModel extends Observable{
		
		public void changeSomething(){
			setChanged();
			notifyObservers();
		}
		
	}
	
	private MyView view;
	private MyModel model;

}
