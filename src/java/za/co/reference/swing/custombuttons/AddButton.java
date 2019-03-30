package za.co.reference.swing.custombuttons;

import java.io.File;

import javax.swing.ImageIcon;

public class AddButton extends CustomButton{
	
	public AddButton(){
		File currentDirectory = new File(".");

System.out.println("currentDirectory: " + currentDirectory.getAbsolutePath());

		setIcon(new ImageIcon(ImageFactory.getInstance().getImage("/images/AddNormal.png")));
		setRolloverIcon(new ImageIcon(ImageFactory.getInstance().getImage("/images/AddRollover.png")));
		setPressedIcon(new ImageIcon(ImageFactory.getInstance().getImage("/images/AddPressed.png")));
		setDisabledIcon(new ImageIcon(ImageFactory.getInstance().getImage("/images/AddDisabled.png")));
		setSelectedIcon(new ImageIcon(ImageFactory.getInstance().getImage("/images/AddRollover.png")));
		setToolTipText("Add");
	}

}