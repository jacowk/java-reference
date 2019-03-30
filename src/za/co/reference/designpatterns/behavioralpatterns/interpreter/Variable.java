package za.co.reference.designpatterns.behavioralpatterns.interpreter;

import java.util.HashMap;

public class Variable implements Expression {
    private String name;
    public Variable(String name)       { this.name = name; }
    public int interpret(HashMap<String,Integer> variables)  { 
        return variables.get(name); 
    }
}
