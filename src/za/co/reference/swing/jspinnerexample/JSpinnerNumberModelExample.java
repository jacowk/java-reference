package za.co.reference.swing.jspinnerexample;

import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
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

public class JSpinnerNumberModelExample extends WindowDecorator{

	public JSpinnerNumberModelExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(currentYear, currentYear - 100,
			currentYear + 100, 1);
		JSpinner spinner = new JSpinner();
		spinner.setModel(spinnerNumberModel);
		spinner.setPreferredSize(new Dimension(100, 20));
		JLabel spinnerLabel = new JLabel("Year");
		
		//Make the year be formatted without a thousands separator.
        spinner.setEditor(new JSpinner.NumberEditor(spinner, "#"));
        
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
