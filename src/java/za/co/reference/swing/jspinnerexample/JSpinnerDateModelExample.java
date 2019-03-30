package za.co.reference.swing.jspinnerexample;

import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

/*
 * There are 3 spinner models
 * 1. SpinnerListModel: Values are defined by an array of objects or a List object
 * 2. SpinnerNumberModel: Supports sequences of numbers which can be expressed as double objects, int objects or Number objects.
 * 							You can specify min, max values and step size
 * 		SpinnerModel model =
        new SpinnerNumberModel(currentYear, //initial value
                               currentYear - 100, //min
                               currentYear + 100, //max
                               1);                //step

 * 3. SpinnerDateModel: Supports sequences of Date objects
 * 		Date initDate = calendar.getTime();
			calendar.add(Calendar.YEAR, -100);
			Date earliestDate = calendar.getTime();
			calendar.add(Calendar.YEAR, 200);
			Date latestDate = calendar.getTime();
			model = new SpinnerDateModel(initDate,
                             earliestDate,
                             latestDate,
                             Calendar.YEAR);

 * 
 */

public class JSpinnerDateModelExample extends WindowDecorator{

	public JSpinnerDateModelExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		
		Calendar calendar = Calendar.getInstance();
		Date initDate = calendar.getTime();
		calendar.add(Calendar.YEAR, -100);
		Date earliestDate = calendar.getTime();
		calendar.add(Calendar.YEAR, 200);
		Date latestDate = calendar.getTime();
		SpinnerDateModel spinnerDateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, 
			Calendar.YEAR);
		JSpinner spinner = new JSpinner();
		spinner.setModel(spinnerDateModel);
		spinner.setPreferredSize(new Dimension(100, 20));
		JLabel spinnerLabel = new JLabel("Date");
		
		//Format the date.
		spinner.setEditor(new JSpinner.DateEditor(spinner, "MM/yyyy"));
        
		spinnerLabel.setLabelFor(spinner);
		panel.add(spinnerLabel);
		panel.add(spinner);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

}
