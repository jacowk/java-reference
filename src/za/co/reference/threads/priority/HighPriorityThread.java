package za.co.reference.threads.priority;

public class HighPriorityThread extends Thread {
	
	public void run(){
		this.setPriority(Thread.MAX_PRIORITY);
		for (int i = 0; i < 5; i++){
			System.out.println(i + ", Name: " + getName() + ", Priority: " + getPriority());
		}
	}

}
