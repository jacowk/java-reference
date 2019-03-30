package za.co.reference.designpatterns.behavioralpatterns.strategy;

//StrategyExample test application

public class StrategyExample {
 
    public static void main(String[] args) {
 
        Context context;
 
        // Three contexts following different strategies
        context = new Context(new ConcreteStrategyAdd());
        int resultA = context.executeStrategy(3,4);
 
        context = new Context(new ConcreteStrategySubtract());
        int resultB = context.executeStrategy(3,4);
 
        context = new Context(new ConcreteStrategyMultiply());
        int resultC = context.executeStrategy(3,4);
 
    }
 
}
