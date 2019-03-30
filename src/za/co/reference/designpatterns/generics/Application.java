package za.co.reference.designpatterns.generics;

public class Application<T>{

	public void run(T t){
		if (t instanceof Man){
			Man man = (Man)t;
			man.saySomething();
		}
		else if (t instanceof Woman){
			Woman woman = (Woman)t;
			woman.saySomething();
		}
	}
	
}
