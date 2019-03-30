package za.co.reference.designpatterns.behavioralpatterns.interpreter;

import java.util.HashMap;

public class Minus implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public Minus(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }
 
    public int interpret(HashMap<String,Integer> variables)  { 
        return leftOperand.interpret(variables) - rightOperand.interpret(variables);
    }
}
