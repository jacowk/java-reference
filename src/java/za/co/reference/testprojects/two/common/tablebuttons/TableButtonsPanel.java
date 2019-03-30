package za.co.reference.testprojects.two.common.tablebuttons;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import za.co.reference.testprojects.two.common.button.Button;
import za.co.reference.testprojects.two.common.button.ButtonName;

public class TableButtonsPanel extends JPanel{
	
	public TableButtonsPanel(ActionListener actionListener){
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		setLayout(flowLayout);
		
		JButton addButton = new Button(ButtonName.ADD, actionListener);
		add(addButton);
		
		JButton modifyButton = new Button(ButtonName.MODIFY, actionListener);
		add(modifyButton);
		
		JButton deleteButton = new Button(ButtonName.DELETE, actionListener);
		add(deleteButton);
		
		JButton viewButton = new Button(ButtonName.VIEW, actionListener);
		add(viewButton);
	}
	
}
