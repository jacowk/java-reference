package za.co.reference.designpatterns.structuralpatterns.bridge;

public class PrintRecordOne implements PrintRecord{

	@Override
	public void printRecord(String firstname, String surname){
		System.out.println("My name is " + firstname + " and my surname is " + surname);
	}

}
