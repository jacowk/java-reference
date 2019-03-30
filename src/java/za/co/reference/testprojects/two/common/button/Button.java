package za.co.reference.testprojects.two.common.button;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton{
	
	public Button(ButtonName tableButtonName, ActionListener actionListener){
		super(tableButtonName.getName());
		setActionCommand(tableButtonName.getName());
		addActionListener(actionListener);
	}

}
