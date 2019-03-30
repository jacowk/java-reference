package za.co.reference.testprojects.one;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MenuBar extends JPanel{
	
	public MenuBar(LaunchButton launchButton){
		setLayout(new BorderLayout());
		add(launchButton, BorderLayout.WEST);
	}

}
