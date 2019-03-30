package za.co.reference.utility;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;

public class Desktop extends JPanel{
	
	public Desktop(){
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Image background = ImageUtilities.loadBufferedImage("C:\\Development\\Playspace\\Reference\\background.jpg");
		g.drawImage(background, 0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight(), null);
	}
	
	Dimension screenSize = HelperUtilities.getSingleScreenSize();

}
