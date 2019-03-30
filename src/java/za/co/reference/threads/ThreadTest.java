package za.co.reference.threads;

public class ThreadTest implements Runnable{
	
	public ThreadTest(String name){
		this.name = name;
		thread = new Thread(this, name);
		thread.start();
	}
	
	public static void main(String[] args) {
		ThreadTest one = new ThreadTest("one");
		ThreadTest two = new ThreadTest("two");
		ThreadTest three = new ThreadTest("three");
		System.out.println("one is alive: " + one.thread.isAlive());
		System.out.println("two is alive: " + two.thread.isAlive());
		System.out.println("three is alive: " + three.thread.isAlive());
		try{
			one.thread.join();
			two.thread.join();
			three.thread.join();
		}
		catch (InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("one is alive: " + one.thread.isAlive());
		System.out.println("two is alive: " + two.thread.isAlive());
		System.out.println("three is alive: " + three.thread.isAlive());
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++){
			System.out.println(name + ": " + i);
			try{
				Thread.sleep(1000);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	private String name;
	private Thread thread;

}
