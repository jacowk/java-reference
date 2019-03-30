package za.co.reference.designpatterns.behavioralpatterns.strategy;

public class ConcreteStrategySubtract implements Strategy {
 
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategyB's execute()");
        return a - b;  // Do a subtraction with a and b
    }
 
}
