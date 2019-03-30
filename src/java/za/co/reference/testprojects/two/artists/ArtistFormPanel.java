package za.co.reference.testprojects.two.artists;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import za.co.reference.testprojects.two.common.form.Form;
import za.co.reference.testprojects.two.common.form.FormState;
import za.co.reference.testprojects.two.database.DatabaseAccess;

public class ArtistFormPanel extends Form{
	
	public ArtistFormPanel(ActionListener actionListener, String title, FormState formState, ArtistListWindow artistListWindow){
		super(actionListener, title, formState);
		this.artistListWindow = artistListWindow;
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Name");
		JTextField nameTextField = new JTextField();
		nameTextField.setPreferredSize(new Dimension(100, 20));
		namePanel.add(nameLabel, BorderLayout.WEST);
		namePanel.add(nameTextField, BorderLayout.CENTER);
		getContentPane().add(namePanel, BorderLayout.CENTER);
		if (formState == FormState.ADD){
			
		}
		else if (formState == FormState.MODIFY){
			int selectedRow = artistListWindow.getArtistTable().getSelectedRow();
			int selectedRowInColumn = artistListWindow.getArtistTable().convertColumnIndexToModel(selectedRow);
//			Artist artist = artistListWindow.getArtistTableModel().getRowCount(selectedRowInColumn);
//			artistListWindow.getArtistTableModel()
//			
//			databaseAccess.getArtistById();
		}
		else if (formState == FormState.VIEW){
			
		}
		
		pack();
		setVisible(true);
	}
	
	private DatabaseAccess databaseAccess = new DatabaseAccess();
	private ArtistListWindow artistListWindow;

}
