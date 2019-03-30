package za.co.reference.threads.priority;

public class PriorityTest {
	
	public static void main(String[] args) {
		new LowPriorityThread().start();
		new HighPriorityThread().start();
//		new NormalPriorityThread().start();
	}

}
