package za.co.reference.testprojects.one;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TableSearchPanel extends JPanel{
	
	public TableSearchPanel(){
		
	}
	
	public TableSearchPanel(ArtistListWindow artistListWindow){
		this.artistListWindow = artistListWindow;
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(300, 20));
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new SearchAction());
		searchButton.setActionCommand("search");
		
		setLayout(new FlowLayout());
		add(searchField);
		add(searchButton);
	}
	
	public class SearchAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event){
			DatabaseAccess databaseAccess = new DatabaseAccess();
			if (event.getActionCommand().equals("search")){
				String searchString = searchField.getText();
				List<Artist> artistSearchResult = databaseAccess.searchArtist(searchString);
				artistListWindow.getArtistTableModel().setArtistList(artistSearchResult);
				artistListWindow.getArtistTableModel().fireTableDataChanged();
			}
		}
		
	}
	
	private JTextField searchField;
//	private DatabaseAccess databaseAccess = new DatabaseAccess();
	private ArtistListWindow artistListWindow;

}
