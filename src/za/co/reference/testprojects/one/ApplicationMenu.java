package za.co.reference.testprojects.one;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import za.co.reference.utility.Desktop;

public class ApplicationMenu extends JPopupMenu implements ActionListener{
	
	public ApplicationMenu(Desktop desktop){
		this.desktop = desktop;
		JMenuItem artistMenu = new JMenuItem("Artist");
		artistMenu.addActionListener(this);
		artistMenu.setActionCommand("artist");
		add(artistMenu);
		add(new JMenuItem("Menu 2"));
		add(new JMenuItem("Menu 3"));
		add(new JMenuItem("Menu 4"));
		addSeparator();
		add(new JMenuItem("Menu 5"));
		add(new JMenuItem("Menu 6"));
		addSeparator();
		add(new JMenuItem("Menu 7"));
	}
	
	public void show(Component invoker, int width, int height){
		super.show(invoker, width, height);
	}

	@Override
	public void actionPerformed(ActionEvent event){
		if (event.getActionCommand().equals("artist")){
			new ArtistListPresenter(desktop);
		}
	}
	
	private Desktop desktop;

}
