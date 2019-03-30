package za.co.reference.swing.jtoolbarexample;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JToolbarExample extends WindowDecorator{

	public JToolbarExample(Window decoratedWindow){
		super(decoratedWindow);
		JToolBar toolbar = new JToolBar();
		JButton buttonOne = new JButton("Button 1");
		toolbar.add(buttonOne);
		JButton buttonTwo = new JButton("Button 2");
		toolbar.add(buttonTwo);
//		toolbar.setFloatable(true); //To make the toolbar immovable
//		toolbar.setRollover(true); //Indicate the 
		
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		panel.add(toolbar);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

}
