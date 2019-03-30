package za.co.reference.swing.jformattedtextfield;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JFormattedTextfieldNumberFieldExample extends WindowDecorator{

	public JFormattedTextfieldNumberFieldExample(Window decoratedWindow){
		super(decoratedWindow);
		// Support an integer number; if a decimal point is typed,
		// the decimal point and all following characters are discarded
		JFormattedTextField tft1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		tft1.setValue(new Integer(123));
		
		// Retrieve the value from the text field 
		Integer intValue = (Integer)tft1.getValue();
		
		// Support a decimal number with one digit following the decimal point; 
		// if more digits after the decimal point is typed, the value is rounded to one decimal place
		JFormattedTextField tft2 = new JFormattedTextField(new DecimalFormat("#.0"));
		tft2.setValue(new Float(123.4F)); 
		
		// Retrieve the value from the text field 
		Float floatValue = (Float)tft2.getValue();
		
		// Support a decimal number with arbitrary number of decimal digits.
		// Actually, this isn't technically possible using DecimalFormat;
		// the best that we can do is to specify lots of #'s
		JFormattedTextField tft3 = new JFormattedTextField(new BigDecimal("123.4567"));
		DefaultFormatter fmt = new NumberFormatter(new DecimalFormat("#.0###############"));
		fmt.setValueClass(tft3.getValue().getClass());
		DefaultFormatterFactory fmtFactory = new DefaultFormatterFactory(fmt, fmt, fmt);
		tft3.setFormatterFactory(fmtFactory); 
		
		// Retrieve the value from the text field
		BigDecimal bigValue = (BigDecimal)tft3.getValue();
		
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
