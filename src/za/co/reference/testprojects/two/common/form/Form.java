package za.co.reference.testprojects.two.common.form;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

import za.co.reference.testprojects.two.common.button.Button;
import za.co.reference.testprojects.two.common.button.ButtonName;

public class Form extends JDialog{
	
	public Form(ActionListener actionListener, String title, FormState formState){
		JPanel buttonPanel = new JPanel();
		if (formState == FormState.ADD || formState == FormState.MODIFY){
			Button saveButton = new Button(ButtonName.SAVE, actionListener);
			Button cancelButton = new Button(ButtonName.CANCEL, actionListener);
			buttonPanel.add(saveButton);
			buttonPanel.add(cancelButton);
		}
		else if (formState == FormState.VIEW){
			Button closeButton = new Button(ButtonName.CLOSE, actionListener);
			buttonPanel.add(closeButton);
		}
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		setModal(true);
		setTitle(title);
		setLocationRelativeTo(getParent());
	}

}
