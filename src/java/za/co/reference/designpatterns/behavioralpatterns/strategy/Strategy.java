package za.co.reference.designpatterns.behavioralpatterns.strategy;

//The classes that implement a concrete strategy should implement this

//The context class uses this to call the concrete strategy
public interface Strategy {

 int execute(int a, int b);

}
