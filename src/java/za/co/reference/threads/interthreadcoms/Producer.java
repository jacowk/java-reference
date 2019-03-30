package za.co.reference.threads.interthreadcoms;

public class Producer implements Runnable {
	
	public Producer(Queue queue){
		this.queue = queue;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++){
			queue.put(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		int i = 0;
//		while (true){
//			queue.put(i++);
//		}
	}
	
	private Queue queue;
	protected Thread thread;
	
}
