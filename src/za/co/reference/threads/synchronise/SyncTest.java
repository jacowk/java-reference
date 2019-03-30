package za.co.reference.threads.synchronise;

public class SyncTest {
	
	public static void main(String[] args) {
		SyncCall syncCall = new SyncCall();
		SyncThread one = new SyncThread("Hello", syncCall);
		SyncThread two = new SyncThread("Synchronized", syncCall);
		SyncThread three = new SyncThread("World", syncCall);
		try{
			one.thread.join();
			two.thread.join();
			three.thread.join();
		}
		catch (InterruptedException ie){
			ie.printStackTrace();
		}
	}

}
