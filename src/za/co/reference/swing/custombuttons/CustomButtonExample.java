package za.co.reference.swing.custombuttons;

import javax.swing.JPanel;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class CustomButtonExample extends WindowDecorator{

	public CustomButtonExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		AddButton addButton = new AddButton();
		panel.add(addButton);
		addPanel(panel);
	}
	
	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

}