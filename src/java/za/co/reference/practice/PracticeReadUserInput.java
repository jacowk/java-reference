package za.co.reference.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PracticeReadUserInput{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter something: ");
		String userInput = br.readLine();
		System.out.println("You entered: " + userInput);
		br.close();
	}

}
