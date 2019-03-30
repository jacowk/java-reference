package za.co.reference.designpatterns.behavioralpatterns.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MediatorDemo extends JFrame implements ActionListener{

	public MediatorDemo(){
		JPanel p = new JPanel();
		p.add(new BtnView(this, mediator));
		p.add(new BtnSearch(this, mediator));
		getContentPane().add(new DisplayLabel(mediator), "North");
		getContentPane().add(p, "South");
		setSize(400,200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent action){
		Command command = (Command)action.getSource();
		command.execute();
	}
	
	public static void main(String[] args){
		new MediatorDemo();
	}
	
	private Mediator mediator = new Mediator();

}
