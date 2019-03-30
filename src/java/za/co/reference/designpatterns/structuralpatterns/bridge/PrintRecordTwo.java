package za.co.reference.designpatterns.structuralpatterns.bridge;

public class PrintRecordTwo implements PrintRecord{

	@Override
	public void printRecord(String firstname, String surname){
		System.out.println(firstname + " " + surname + " is a name.");
	}

}
