package za.co.reference.threads.synchronise;

public class SyncThread implements Runnable {
	
	public SyncThread(String name, SyncCall syncCall){
		this.name = name;
		this.syncCall = syncCall;
		thread = new Thread(this, name);
		thread.start();
	}
	
	@Override
	public void run(){
//		for (int i = 0; i < 5; i++){
//			synchronized(syncCall){
				syncCall.call(name);
//			}
//		}
	}
	
	private String name;
	public Thread thread;
	private SyncCall syncCall;

}
