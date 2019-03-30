package za.co.reference.designpatterns.behavioralpatterns.interpreter;

import java.util.HashMap;

public interface Expression{
	
	public int interpret(HashMap<String,Integer> variables);

}
