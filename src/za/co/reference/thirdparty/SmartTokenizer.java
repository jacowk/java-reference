package za.co.reference.thirdparty;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class SmartTokenizer{

	public SmartTokenizer(String string, String delimiter){
		tokens = new ArrayList();
		current = 0;
		StringTokenizer tokenizer = new StringTokenizer(string, delimiter, true);
		boolean wasDelimiter = true;
		boolean isDelimiter = false;
		while (tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			isDelimiter = token.equals(delimiter);
			if (wasDelimiter){
				tokens.add(isDelimiter ? "" : token);
			}
			else if (!isDelimiter){
				tokens.add(token);
			}
			wasDelimiter = isDelimiter;
		}
		if (isDelimiter){
			tokens.add("");
		}
	}

	public int countTokens(){
		return tokens.size();
	}

	public boolean hasMoreTokens(){
		return current < tokens.size();
	}

	public boolean hasMoreElements(){
		return hasMoreTokens();
	}

	public Object nextElement(){
		return nextToken();
	}

	public String nextToken(){
		String token = (String) tokens.get(current);
		current++;
		return token;
	}
	
	private ArrayList tokens;
	private int current;
	  
}

