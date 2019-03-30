package za.co.reference.testprojects.two;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MusicApplication extends JFrame{
	
	public MusicApplication(){
		setJMenuBar(musicMenu);
		musicDesktop.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(musicDesktop, BorderLayout.CENTER);
		setPreferredSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
		setTitle("Music Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	private MusicDesktop musicDesktop = new MusicDesktop();
	private MusicMenu musicMenu = new MusicMenu(musicDesktop);

}
