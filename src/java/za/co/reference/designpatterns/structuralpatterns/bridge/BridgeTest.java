package za.co.reference.designpatterns.structuralpatterns.bridge;

public class BridgeTest{
	
	public static void main(String[] args){
		PrintRecord printRecord = new PrintRecordOne();
		PrintAPI printAPI = new PrintAPIOne(printRecord);
		printAPI.setData("John", "Doe");
		printAPI.printPerson();
		
		printRecord = new PrintRecordTwo();
		printAPI = new PrintAPIOne(printRecord);
		printAPI.setData("Jane", "Doe");
		printAPI.printPerson();
	}

}
