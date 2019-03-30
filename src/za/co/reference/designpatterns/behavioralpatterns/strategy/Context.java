package za.co.reference.designpatterns.behavioralpatterns.strategy;

// Configured with a ConcreteStrategy object and maintains a reference to a Strategy object
public class Context {
 
    private Strategy strategy;
 
    // Constructor
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
 
    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
 
}
