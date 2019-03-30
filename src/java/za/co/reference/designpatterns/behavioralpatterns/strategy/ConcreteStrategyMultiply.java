package za.co.reference.designpatterns.behavioralpatterns.strategy;

public class ConcreteStrategyMultiply implements Strategy {
 
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategyC's execute()");
        return a  * b;   // Do a multiplication with a and b
    }
 
}
