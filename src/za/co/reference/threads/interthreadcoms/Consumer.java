package za.co.reference.threads.interthreadcoms;

public class Consumer implements Runnable{
	
	public Consumer(Queue queue){
		this.queue = queue;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true){
			queue.get();
		}
	}
	
	private Queue queue;
	protected Thread thread;

}
