package za.co.reference.swing.jformattedtextfield;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.text.DateFormatter;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JFormattedTextfieldDateFieldExample  extends WindowDecorator{

	public JFormattedTextfieldDateFieldExample(Window decoratedWindow){
		super(decoratedWindow);
		
		// Support a date in the MEDIUM format in the current locale;
		// see Formatting and Parsing a Date Using Default Formats.
		// For Locale.ENGLISH, the format would be Feb 8, 2002.
		JFormattedTextField tft1 = new JFormattedTextField(new Date());

		// Support a date in the SHORT format using the current locale.
		// For Locale.ENGLISH, the format would be 2/8/02.
		JFormattedTextField tft2 = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
		tft2.setValue(new Date());

		// Support a date with the custom format: 2002-8-2
		JFormattedTextField tft3 = new JFormattedTextField(new SimpleDateFormat("yyyy-M-d"));
		tft3.setValue(new Date());

		// See also Formatting a Date Using a Custom Format
		// Retrieve the date from the text field
		Date date = (Date)tft3.getValue();

		// Change the format to: 2/8/2002
		DateFormatter fmt = (DateFormatter)tft3.getFormatter();
		fmt.setFormat(new SimpleDateFormat("d/M/yyyy"));

		// Reformat the display
		tft3.setValue(tft3.getValue()); 

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
