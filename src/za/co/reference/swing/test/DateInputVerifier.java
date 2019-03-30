package za.co.reference.swing.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class DateInputVerifier extends InputVerifier{

	public DateInputVerifier(){
System.out.println("DateInputVerifier.DateInputVerifier()");
		dateFormat.setLenient(false);
	}

	@Override
    public boolean verify(JComponent input){
System.out.println("DateInputVerifier.verify()");
		if (input instanceof JTextField){
			try{
				String inputText = ((JTextField) input).getText().trim();
				/* No text specifies no date - this is valid. */
				if ((inputText.length() != 0) && !inputText.equals("YYYYMMDD")){
					if (inputText.length() == 8){
						StringBuffer formattedText = new StringBuffer(10);
						char[] inputTextCharacters = inputText.toCharArray();
						for (int i = 0; i < inputTextCharacters.length; i++){
							if ((i == 4) || (i == 6)){
								formattedText.append("/");
							}
							if (Character.isDigit(inputTextCharacters[i])){
								formattedText.append(inputTextCharacters[i]);
							}
							else{
								return false;
							}
						}
						inputText = formattedText.toString();
						dateFormat.parse(inputText);
						((JTextField) input).setText(inputText);
					}
					else{
						dateFormat.parse(inputText);
					}
				}
			}
			catch (ParseException e){
				return false;
			}
		}
		return true;
	}

	@Override
    public boolean shouldYieldFocus(JComponent input){
System.out.println("DateInputVerifier.shouldYieldFocus()");
		verify(input);
		return true;
	}

	public void setDateFormat(DateFormat dateFormat){
System.out.println("DateInputVerifier.setDateFormat()");
		this.dateFormat = dateFormat;
	}

	public DateFormat getDateFormat(){
System.out.println("DateInputVerifier.getDateFormat()");
		return dateFormat;
	}

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

}