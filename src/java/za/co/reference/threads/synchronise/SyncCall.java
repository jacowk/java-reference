package za.co.reference.threads.synchronise;

public class SyncCall {
	
	public synchronized void call(String value){
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(value + " ");
	}

}
