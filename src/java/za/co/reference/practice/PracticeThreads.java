package za.co.reference.practice;

public class PracticeThreads{
	
	private class ThreadWithThread extends Thread{
		
		public void run(){
			for (int i = 0; i < 10; i++){
				System.out.println("Hello world from ThreadWithThread");
				suspendThread(1000);
			}
		}
		
	}
	
	private class ThreadWithRunnable implements Runnable{

		@Override
		public void run(){
			for (int i = 0; i < 10; i++){
				System.out.println("Hello world from ThreadWithRunnable");
				suspendThread(1000);
			}
		}
		
	}
	
	/* 
	 * If multiple threads access this method, use synchronized to have one thread wait while the other
	 * calls this method. It prevents the thread from being accessed simultaniously 
	 * */
	private synchronized void suspendThread(int sleepTime){
		try{
			Thread.sleep(sleepTime);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		PracticeThreads threads = new PracticeThreads();
		ThreadWithThread threadOne = threads.new ThreadWithThread();
		ThreadWithRunnable threadTwo = threads.new ThreadWithRunnable();
		threadOne.start(); //Start the thread
		threadTwo.run();
//		threadOne.isAlive(); //Check if thread is running
//		threadOne.join(); //Wait for another thread to finish
//		threadOne.isInterrupted(); //Check if a thread was interrupted and stopped working (Allways check this)
//		threadOne.wait(); //Suspends current thread
//		threadOne.notify(); //Wakes up a waiting thread (notifyAll() wakes up all waiting threads)
		
	}

}
