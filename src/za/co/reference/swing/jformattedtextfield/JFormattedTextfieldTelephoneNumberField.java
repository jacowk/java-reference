package za.co.reference.swing.jformattedtextfield;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JFormattedTextfieldTelephoneNumberField extends WindowDecorator{

	public JFormattedTextfieldTelephoneNumberField(Window decoratedWindow){
		super(decoratedWindow);
		
		MaskFormatter fmt = null;
		
		// A phone number 
		try{
			fmt = new MaskFormatter("###-###-####");
		}
		catch (java.text.ParseException e){
			
		}
		JFormattedTextField tft1 = new JFormattedTextField(fmt);
		
		// A social security number
		try{
			fmt = new MaskFormatter("###-##-####");
		}
		catch (java.text.ParseException e){
			
		}
		JFormattedTextField tft2 = new JFormattedTextField(fmt);
		
		// A social security number
		fmt.setPlaceholderCharacter('*');
		JFormattedTextField tft3 = new JFormattedTextField(fmt);
		
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		panel.add(tft1);
		panel.add(tft2);
		panel.add(tft3);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

}
