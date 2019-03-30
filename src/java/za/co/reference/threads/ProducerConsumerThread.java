package za.co.reference.threads;

//Concurrent Programming in Java: Design Principles and Patterns by Doug Lea (Book)
//http://www.javaworld.com/javaworld/jw-05-2002/jw-0503-java101.html?
public class ProducerConsumerThread{
	
	public static void main(String args[]){
		ProducerConsumerThread test = new ProducerConsumerThread();
		Queue queue = test.new Queue();
		test.new Producer(queue);
		test.new Consumer(queue);
		System.out.println("Press Control-C to stop.");
	}
	
	// A correct implementation of a producer and consumer. 
	class Queue{
		
		synchronized int get(){
			if (!valueSet)
			try{
				wait();
			}
			catch(InterruptedException e){
				System.out.println("InterruptedException caught");
			}
			System.out.println("Got: " + n);
			valueSet = false;
			notify();
			return n;
		}
		
		synchronized void put(int n){
			if (valueSet)
			try{
				wait();
			}
			catch(InterruptedException e){
				System.out.println("InterruptedException caught");
			}
			this.n = n; 
			valueSet = true;
			System.out.println("Put: " + n);
			notify();
		}
		
		int n; 
		boolean valueSet = false;
		
	}

	class Producer implements Runnable{
		 
		Producer(Queue queue){
			this.queue = queue;
			new Thread(this, "Producer").start();
		}
		
		public void run(){
			int i = 0;
			while(true){
				queue.put(i++);
			}
		}
		
		Queue queue;
		
	}

	class Consumer implements Runnable{
		
		Consumer(Queue queue){
			this.queue = queue;
			new Thread(this, "Consumer").start();
		}
		
		public void run(){
			while(true){
				queue.get();
			}
		}
		
		Queue queue;
		
	}

}
