package za.co.reference.testprojects.two.common.search;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import za.co.reference.testprojects.two.common.button.Button;
import za.co.reference.testprojects.two.common.button.ButtonName;
import za.co.reference.testprojects.two.database.DatabaseAccess;

public class TableSearchPanel extends JPanel{
	
	public TableSearchPanel(JTable table, String labelText, ActionListener actionListener){
		JLabel searchLabel = new JLabel(labelText);
		JTextField searchTextField = new JTextField();
		searchTextField.setPreferredSize(new Dimension(300, 20));
		JButton searchButton = new Button(ButtonName.SEARCH, actionListener);
		
		add(searchLabel, BorderLayout.WEST);
		add(searchTextField, BorderLayout.CENTER);
		add(searchButton, BorderLayout.SOUTH);
	}
	
	private DatabaseAccess databaseAccess = new DatabaseAccess();

}
