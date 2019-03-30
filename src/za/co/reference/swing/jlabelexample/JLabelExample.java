package za.co.reference.swing.jlabelexample;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JLabelExample extends WindowDecorator{

	public JLabelExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		JLabel label = new JLabel("This is a test label");
		label.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(label);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

}
