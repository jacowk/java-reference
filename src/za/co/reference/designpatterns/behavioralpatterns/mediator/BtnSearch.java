package za.co.reference.designpatterns.behavioralpatterns.mediator;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BtnSearch extends JButton implements Command{

	public BtnSearch(ActionListener action, Mediator mediator){
		super("Search");
		addActionListener(action);
		this.mediator = mediator;
		this.mediator.registerSearch(this);
	}
	
	@Override
	public void execute(){
		mediator.search();
	}
	
	public Mediator mediator;

}
