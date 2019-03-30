package za.co.reference.testprojects.one;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import za.co.reference.utility.Desktop;
import za.co.reference.utility.HelperUtilities;

public class TestApplication extends JFrame{
	
	public TestApplication(){
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(desktop, BorderLayout.CENTER);
		getContentPane().add(menuBar, BorderLayout.NORTH);
		setLocationRelativeTo(null); //To centre the window
		setPreferredSize(new Dimension(800, 600));
		pack();
		setTitle("Artist");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximize the window
		setVisible(true);
	}
	
	Dimension screenSize = HelperUtilities.getSingleScreenSize();
	Desktop desktop = new Desktop();
	ApplicationMenu applicationMenu = new ApplicationMenu(desktop);
	LaunchButton launchButton = new LaunchButton(applicationMenu);
	MenuBar menuBar = new MenuBar(launchButton);

}
