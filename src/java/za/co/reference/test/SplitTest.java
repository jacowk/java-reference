package za.co.reference.test;

public class SplitTest{

	public static void main(String[] args){
		String var = "one.two.three";
		String[] varSplit = var.split("\\.");
		System.out.println(varSplit.length);
		for (String string : varSplit) {
			System.out.println("String: " + string);
		}
	}
	
}