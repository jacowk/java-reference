package za.co.reference.designpatterns.behavioralpatterns.interpreter;

import java.util.HashMap;

public class Number implements Expression {
    private int number;
    public Number(int number)       { this.number = number; }
    public int interpret(HashMap<String,Integer> variables)  { return number; }
}
