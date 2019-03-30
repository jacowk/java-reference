package za.co.reference.threads.interthreadcoms;

public class Queue {
	
	public synchronized void put(int value){
//		System.out.println("Queue.put(): " + value + ", " + valueSet);
		if (valueSet){
			try{
				wait();
			}
			catch (InterruptedException ie){
				ie.printStackTrace();
			}
		}
			
		this.value = value;
		valueSet = true;
		System.out.println("Put: " + value);
		notify();
	}
	
	public synchronized int get(){
//		System.out.println("Queue.get(): " + value + ", " + valueSet);
		if (!valueSet){
			try{
				wait();
			}
			catch (InterruptedException ie){
				ie.printStackTrace();
			}
		}
		
		valueSet = false;
		System.out.println("Got: " + value);
		notify();
		return value;
	}
	
	private boolean valueSet = false;
	private int value;

}
