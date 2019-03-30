package za.co.reference.swing.test;

import java.text.ParseException;
import java.util.Date;

public class DateTextField extends FormattedTextField{

	public DateTextField(){
		super("YYYYMMDD");
System.out.println("DateTextField.DateTextField()");
		setInputVerifier(verifier);
	}

	public void setDate(Date date){
System.out.println("DateTextField.setDate()");
		if (date != null){
			setText(verifier.getDateFormat().format(date));
		}
		else if (isEditable()){
			setText("YYYYMMDD");
		}
		else{
			setText(null);
		}
	}

	public Date getDate(){
System.out.println("DateTextField.getDate()");
		try{
			return verifier.getDateFormat().parse(getText());
		}
		catch (ParseException e){
			return null;
		}
	}

	public boolean isInputValid(){
System.out.println("DateTextField.isInputValid()");
		return verifier.verify(this);
	}

	private DateInputVerifier verifier = new DateInputVerifier();
	
}