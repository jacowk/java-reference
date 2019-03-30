package za.co.reference.testprojects.one;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FormButton extends JButton{
	
	FormButton(String buttonName, String actionCommand, ActionListener actionListener){
		super(buttonName);
		setActionCommand(actionCommand);
		addActionListener(actionListener);
	}

}
