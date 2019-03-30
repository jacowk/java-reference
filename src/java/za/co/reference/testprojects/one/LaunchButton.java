package za.co.reference.testprojects.one;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import za.co.reference.utility.HelperUtilities;

public class LaunchButton extends JLabel implements MouseListener{
	
	public LaunchButton(ApplicationMenu applicationMenu){
		this.applicationMenu = applicationMenu;
		setText("Menu");
		setFont(HelperUtilities.getFont("Arial", Font.BOLD, 16));
		setBackground(Color.WHITE);
		setOpaque(true);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent event){
		
	}

	@Override
	public void mouseEntered(MouseEvent event){
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		
	}

	@Override
	public void mousePressed(MouseEvent event){
		setBackground(Color.YELLOW);
		applicationMenu.show(this, 0, getHeight());
	}

	@Override
	public void mouseReleased(MouseEvent event){
		setBackground(Color.WHITE);
	}
	
	private ApplicationMenu applicationMenu;

}
