package za.co.reference.testprojects.two.artists;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import za.co.reference.testprojects.two.MusicDesktop;
import za.co.reference.testprojects.two.common.search.TableSearchPanel;
import za.co.reference.testprojects.two.common.tablebuttons.TableButtonsPanel;
import za.co.reference.testprojects.two.database.DatabaseAccess;

public class ArtistListWindow extends JInternalFrame{
	
	public ArtistListWindow(MusicDesktop musicDesktop){
		JTable artistTable = new JTable(artistTableModel);
		artistTable.setPreferredScrollableViewportSize(new Dimension(445, 350));
		artistTable.setFillsViewportHeight(true);
		artistTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane artistScrollPane = new JScrollPane(artistTable);
		TableSearchPanel tableSearchPanel = new TableSearchPanel(artistTable, "Artist Name", artistTableActionListener);
		getContentPane().add(tableSearchPanel, BorderLayout.NORTH);
		getContentPane().add(artistScrollPane, BorderLayout.CENTER);
		getContentPane().add(tableButtonsPanel, BorderLayout.SOUTH);
		
		setTitle("Artists");
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		pack();
//		setLocation(SwingUtilities.centreInternalFrame(this, musicDesktop));
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		this.musicDesktop = musicDesktop;
		this.musicDesktop.add(this);
		setVisible(true);
	}
	
	private class ArtistTableModel extends AbstractTableModel{
		
		public ArtistTableModel(){
			artistList = databaseAccess.retrieveAllArtists();
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
			switch (column){
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
				return "Name";
			}
			return "";
		}
		
		public List<Artist> getArtist(){
			return artistList;
		}
		
		public void setArtist(List<Artist> artistList){
			this.artistList = artistList;
		}
		
		private List<Artist> artistList =  new LinkedList<Artist>();
		
	}
	
	public AbstractTableModel getArtistTableModel(){
		return artistTableModel;
	}
	
	public JTable getArtistTable(){
		return artistTable;
	}
	
	private MusicDesktop musicDesktop;
	private DatabaseAccess databaseAccess = new DatabaseAccess();
	private ArtistTableModel artistTableModel = new ArtistTableModel();
	private ArtistTableActionListener artistTableActionListener = new ArtistTableActionListener(this);
	private TableButtonsPanel tableButtonsPanel = new TableButtonsPanel(artistTableActionListener);
	private JTable artistTable;

}
