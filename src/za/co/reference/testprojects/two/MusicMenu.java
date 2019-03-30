package za.co.reference.testprojects.two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import za.co.reference.testprojects.two.artists.ArtistListWindow;

public class MusicMenu extends JMenuBar implements ActionListener{
	
	public MusicMenu(MusicDesktop musicDesktop){
		this.musicDesktop = musicDesktop;
		JMenu administrationMenu = new JMenu("Administration");
		
		JMenuItem artistsMenuItem = new JMenuItem("Artists");
		artistsMenuItem.setActionCommand("artists");
		artistsMenuItem.addActionListener(this);
		administrationMenu.add(artistsMenuItem);
		
		JMenuItem albumsMenuItem = new JMenuItem("Albums");
		albumsMenuItem.setActionCommand("albums");
		administrationMenu.add(albumsMenuItem);
		
		JMenuItem recordLabelsMenuItem = new JMenuItem("Record Labels");
		recordLabelsMenuItem.setActionCommand("recordLabels");
		administrationMenu.add(recordLabelsMenuItem);
		
		JMenuItem songsMenuItem = new JMenuItem("Songs");
		songsMenuItem.setActionCommand("songs");
		administrationMenu.add(songsMenuItem);
		
		JMenuItem sponsorsMenuItem = new JMenuItem("Sponsors");
		sponsorsMenuItem.setActionCommand("sponsors");
		administrationMenu.add(sponsorsMenuItem);
		
		add(administrationMenu);
	}

	@Override
	public void actionPerformed(ActionEvent event){
		if (event.getActionCommand().equals("artists")){
			System.out.println("Artists selected");
			new ArtistListWindow(musicDesktop);
		}
	}
	
	public MusicDesktop musicDesktop;
	
}
