package za.co.reference.swing.formattedtextfieldexample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class DateInputVerifier extends InputVerifier{

	@Override
	public boolean verify(JComponent input){
		if (input instanceof JTextField){
			String inputText = ((JTextField) input).getText().trim();
			if ((inputText.length() != 0) && !inputText.equals("YYYY/MM/DD")){
				try{
					dateFormat.parse(inputText);
				}
				catch (ParseException pe){
					return false;
				}
			}
		}
		return true;
	}

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
}