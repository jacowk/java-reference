package za.co.reference.testprojects.one;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import za.co.reference.utility.Desktop;

public class ArtistListWindow extends JInternalFrame implements ListSelectionListener{
	
	public ArtistListWindow(Desktop desktop){
		setTitle("Artist");
		setPreferredSize(new Dimension(500, 500));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
//		setLocationRelativeTo(desktop); //To centre the window
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		TableSearchPanel tableSearchPanel = new TableSearchPanel(this);
		mainPanel.add(tableSearchPanel, BorderLayout.NORTH);
		
		JPanel tablePanel = new JPanel();
		artistTable.setPreferredScrollableViewportSize(new Dimension(445, 350));
		artistTable.setFillsViewportHeight(true);
		artistTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel listSelectionModel = artistTable.getSelectionModel();
        listSelectionModel.addListSelectionListener(this);
        JScrollPane scrollPane = new JScrollPane(artistTable);
		tablePanel.add(scrollPane);
		mainPanel.add(tablePanel, BorderLayout.CENTER);
		
		mainPanel.add(tableButtonsPanel, BorderLayout.SOUTH);
		
		getContentPane().add(mainPanel);
		
		desktop.add(this);
		
		setVisible(true);
	}
	
	public void addRow(Artist artist){
		Artist refreshedData = databaseAccess.getArtistByName(artist);
		artistTableModel.getArtistList().add(artist);
		artistTableModel.fireTableRowsInserted(0, artistTableModel.getArtistList().size());
	}
	
	public class ArtistTableModel extends AbstractTableModel{
		
		ArtistTableModel(){
//			loadData();
		}

		@Override
		public int getColumnCount(){
			return 2;
		}

		@Override
		public int getRowCount(){
			return artistList.size();
		}

		@Override
		public Object getValueAt(int row, int column){
			switch(column){
			case 0:
				return artistList.get(row).getId();
			case 1:
				return artistList.get(row).getName();
			}
			return null;
		}
		
		public String getColumnName(int column){
			switch (column){
			case 0: 
				return "ID";
			case 1:
				return "Artist Name";
			default:
				return null;
			}
        }
		
		public void loadData(){
			artistList = databaseAccess.retrieveAllArtists();
		}
		
		@Override
		public void setValueAt(Object object, int row, int column){
			Artist artist = (Artist)object;
			switch(column){
			case 0:
				artistList.get(row).setId(artist.getId());
			case 1:
				artistList.get(row).setName(artist.getName());
			}
		}
		
		public List<Artist> getArtistList(){
			return artistList;
		}
		
		public void setArtistList(List<Artist> artistList){
			this.artistList = artistList;
		}
		
		public Class getColumnClass(int c){
            return getValueAt(0, c).getClass();
        }
		
		List<Artist> artistList = new ArrayList<Artist>();
		
	}
	
	public ArtistTableModel getArtistTableModel(){
		return artistTableModel;
	}
	
	public JTable getArtistTable(){
		return artistTable;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event){
		tableButtonsPanel.getAddButton().setEnabled(true);
		tableButtonsPanel.getDeleteButton().setEnabled(true);
		tableButtonsPanel.getModifyButton().setEnabled(true);
		tableButtonsPanel.getViewButton().setEnabled(true);
	}
	
	private ArtistTableModel artistTableModel = new ArtistTableModel();
	private JTable artistTable = new JTable(artistTableModel);
	private DatabaseAccess databaseAccess = new DatabaseAccess();
	TableButtonsPanel tableButtonsPanel = new TableButtonsPanel(this); 

}
