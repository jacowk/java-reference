package za.co.reference.random;

import java.util.Random;

public class GenerateRandomNumbers{
	
	public static void main(String[] args){
		Random random = new Random();
//		random.setSeed(2);
		for (int i = 0; i < 5; i++){
			int randomInt = random.nextInt();
			System.out.println("randomInt: " + randomInt);
			long randomLong = random.nextLong();
			System.out.println("randomLong: " + randomLong);
		}
		
	}

}