package za.co.reference.swing.jspinnerexample;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

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

public class JSpinnerListModelExample extends WindowDecorator{

	public JSpinnerListModelExample(Window decoratedWindow){
		super(decoratedWindow);
		String animals[] = {"Dog", "Cat", "Bird", "Elephant", "Lion"};
		JPanel panel = new JPanel();
		SpinnerListModel spinnerListModel = new SpinnerListModel(animals);
		JSpinner spinner = new JSpinner();
		spinner.setModel(spinnerListModel);
		spinner.setPreferredSize(new Dimension(100, 20));
		JLabel spinnerLabel = new JLabel("Animals");
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
