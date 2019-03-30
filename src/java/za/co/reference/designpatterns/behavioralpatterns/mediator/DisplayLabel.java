package za.co.reference.designpatterns.behavioralpatterns.mediator;

import java.awt.Font;

import javax.swing.JLabel;

public class DisplayLabel extends JLabel{
	
	public DisplayLabel(Mediator mediator){
		super("Just start...");
		this.mediator = mediator;
		this.mediator.registerDisplay(this);
		setFont(new Font("Arial", Font.BOLD, 24));
	}
	
	private Mediator mediator;

}
