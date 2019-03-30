package za.co.reference.designpatterns.behavioralpatterns.mediator;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BtnView extends JButton implements Command{

	public BtnView(ActionListener action, Mediator mediator){
		super("View");
		addActionListener(action);
		this.mediator = mediator;
		this.mediator.registerView(this);
	}
	
	@Override
	public void execute(){
		mediator.view();
	}
	
	private Mediator mediator;

}
