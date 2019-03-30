package za.co.reference.designpatterns.structuralpatterns.bridge;

public class PrintAPIOne implements PrintAPI{

	public PrintAPIOne(PrintRecord printRecord){
		this.printRecord = printRecord;
	}
	
	@Override
	public void printPerson(){
		printRecord.printRecord(firstname, surname);
	}

	@Override
	public void setData(String firstname, String surname){
		this.firstname = firstname;
		this.surname = surname;
	}
	
	private String firstname, surname;
	private PrintRecord printRecord;

}
