package za.co.reference.test;

public class FibonacciNumbers{
	
	//0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
	public static void main(String[] args){
//		System.out.println(610 % 24);
		
		FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
		fibonacciNumbers.calculateFibonacciNumbers();
	}
	
	private void calculateFibonacciNumbers(){
		int previousNumber = 0;
		int nextNumber = 1;
		int total = 1;
		System.out.print(previousNumber + " " + nextNumber + " ");
		for (int i = 7; i < 30; i++){
			total = previousNumber + nextNumber;
			System.out.print(alphabet[total % 24]);
//			System.out.print(total + " ");
			previousNumber = nextNumber;
			nextNumber = total;
		}
	}
	
	private void determineNextAlphabetLetter(long fib){
		System.out.println();
	}
	
	private char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

}
