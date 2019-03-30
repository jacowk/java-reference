package za.co.reference.swing.jspinnerexample;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JSpinnerListModelWithChangeListenerExample extends WindowDecorator implements ChangeListener{

	public JSpinnerListModelWithChangeListenerExample(Window decoratedWindow){
		super(decoratedWindow);
		String animals[] = {"Dog", "Cat", "Bird", "Elephant", "Lion"};
		JPanel panel = new JPanel();
		SpinnerListModel spinnerListModel = new SpinnerListModel(animals);
		JSpinner spinner = new JSpinner();
		spinner.setModel(spinnerListModel);
		spinner.setPreferredSize(new Dimension(100, 20));
		spinner.addChangeListener(this);
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

	@Override
	public void stateChanged(ChangeEvent changeEvent){
		JSpinner spinner = (JSpinner)changeEvent.getSource();
		if (spinner.getValue().toString().equals("Bird")){
			System.out.println("You selected Bird");
		}
	}

}
