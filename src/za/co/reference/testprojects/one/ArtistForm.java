package za.co.reference.testprojects.one;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArtistForm extends JDialog{
	
	public ArtistForm(ArtistListWindow artistListWindow, ButtonAction buttonAction){
		this.artistListWindow = artistListWindow;
		
		if (buttonAction == ButtonAction.DELETE){
			
			int selected = JOptionPane.showConfirmDialog(artistListWindow, "Are you sure you want to delete the artist?", 
					"Delete Artist", JOptionPane.OK_CANCEL_OPTION);
			if (selected == 0){
				Artist artist = new Artist();
				int selectedRow = artistListWindow.getArtistTable().getSelectedRow();
				int selectedRecordInModel = artistListWindow.getArtistTable().convertRowIndexToModel(selectedRow);
				Artist selectedArtist = (Artist)artistListWindow.getArtistTableModel().getArtistList().get(selectedRecordInModel);
				artist.setId(selectedArtist.getId());
				databaseAccess.deleteArtist(artist);
				artistListWindow.getArtistTableModel().getArtistList().remove(selectedRecordInModel);
				artistListWindow.getArtistTableModel().fireTableDataChanged();
				dispose();
			}
		}
		else{
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BorderLayout());
			
			JPanel namePanel = new JPanel();
			namePanel.setLayout(new FlowLayout());
			namePanel.add(new JLabel("Name"));
			nameField = new JTextField();
			nameField.setPreferredSize(new Dimension(200, 20));
			namePanel.add(nameField);
			
			JPanel buttonsPanel = new JPanel();
			
			if (buttonAction == ButtonAction.VIEW){
				nameField.setEditable(false);
				FormButton closeButton = new FormButton("Close", "close", formButtonsAction);
				buttonsPanel.add(closeButton);
				Artist artist = new Artist();
				int selectedRow = artistListWindow.getArtistTable().getSelectedRow();
				int selectedRecordInModel = artistListWindow.getArtistTable().convertRowIndexToModel(selectedRow);
				Artist selectedArtist = (Artist)artistListWindow.getArtistTableModel().getArtistList().get(selectedRecordInModel);
				artist.setId(selectedArtist.getId());
				artist = databaseAccess.getArtistById(artist);
				nameField.setText(artist.getName());
			}
			else if (buttonAction == ButtonAction.ADD){
				nameField.setEditable(true);
				FormButton saveButton = new FormButton("Save", "saveAdd", formButtonsAction);
				FormButton cancelButton = new FormButton("Cancel", "cancel", formButtonsAction);
				buttonsPanel.add(saveButton);
				buttonsPanel.add(cancelButton);
			}
			else if (buttonAction == ButtonAction.MODIFY){
				nameField.setEditable(true);
				FormButton saveButton = new FormButton("Save", "saveUpdate", formButtonsAction);
				FormButton cancelButton = new FormButton("Cancel", "cancel", formButtonsAction);
				buttonsPanel.add(saveButton);
				buttonsPanel.add(cancelButton);
				Artist artist = new Artist();
				int selectedRow = artistListWindow.getArtistTable().getSelectedRow();
				int selectedRecordInModel = artistListWindow.getArtistTable().convertRowIndexToModel(selectedRow);
				Artist selectedArtist = (Artist)artistListWindow.getArtistTableModel().getArtistList().get(selectedRecordInModel);
				artist.setId(selectedArtist.getId());
				artist = databaseAccess.getArtistById(artist);
				nameField.setText(artist.getName());
			}
			
			mainPanel.add(namePanel, BorderLayout.NORTH);
			mainPanel.add(buttonsPanel, BorderLayout.CENTER);
			
			add(mainPanel);
			
			setResizable(false);
			setModal(true);
			setTitle(buttonAction.getActionDescription() + " Artist");
			setPreferredSize(new Dimension(300, 100));
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			pack();
			setLocationRelativeTo(artistListWindow);
			setVisible(true);
		}
	}
	
	public void disposeWindow(){
		dispose();
	}
	
	public class FormButtonsAction implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			if (e.getActionCommand().equals("saveAdd")){
				String name = nameField.getText();
				Artist artist = new Artist(name);
				artist.setName(name);
				databaseAccess.addArtist(artist);
				artistListWindow.getArtistTableModel().getArtistList().clear();
				artistListWindow.getArtistTableModel().fireTableDataChanged();
				artistListWindow.addRow(artist);
				dispose();
			}
			else if (e.getActionCommand().equals("saveUpdate")){
				String name = nameField.getText();
				Artist artist = new Artist(name);
				int selectedRow = artistListWindow.getArtistTable().getSelectedRow();
				int selectedRecordInModel = artistListWindow.getArtistTable().convertRowIndexToModel(selectedRow);
				Artist selectedArtist = (Artist)artistListWindow.getArtistTableModel().getArtistList().get(selectedRecordInModel);
				artist.setId(selectedArtist.getId());
				databaseAccess.updateArtist(artist);
				artistListWindow.getArtistTableModel().getArtistList().clear();
				artistListWindow.getArtistTableModel().fireTableDataChanged();
				artistListWindow.addRow(artist);
				dispose();
			}
			else if (e.getActionCommand().equals("cancel")){
				dispose();
			}
			else if (e.getActionCommand().equals("close")){
				dispose();
			}
		}
		
	}
	
	private FormButtonsAction formButtonsAction = new FormButtonsAction();
	private JTextField nameField;
	private DatabaseAccess databaseAccess = new DatabaseAccess();
	private ArtistListWindow artistListWindow;

}
