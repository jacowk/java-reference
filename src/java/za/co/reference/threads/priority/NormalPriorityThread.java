package za.co.reference.threads.priority;

public class NormalPriorityThread extends Thread {
	
	public void run(){
		for (int i = 0; i < 5; i++){
			System.out.println(i + ", Name: " + getName() + ", Priority: " + getPriority());
		}
	}

}
