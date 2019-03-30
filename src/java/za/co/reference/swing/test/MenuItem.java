package za.co.reference.swing.test;

import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.plaf.MenuItemUI;

public class MenuItem extends JMenuItem{

	public MenuItem(){
		setOpaque(false);
//		setUI(new MenuItemUI());
	}

	public MenuItem(String text){
		super(text);
		setOpaque(false);
	}

	public MenuItem(Icon icon){
		super(icon);
		setOpaque(false);
	}

	public MenuItem(String text, Icon icon){
		super(text, icon);
		setOpaque(false);
	}

}
