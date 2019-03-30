package za.co.reference.threads.priority;

public class LowPriorityThread extends Thread {

	public void run(){
		this.setPriority(Thread.MIN_PRIORITY);
		for (int i = 0; i < 5; i++){
			System.out.println(i + ", Name: " + getName() + ", Priority: " + getPriority());
		}
	}
	
}
