package za.co.reference.utility;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

public class HelperUtilities{
	
	public static Dimension getScreenSizeViaDefaultToolkit(){ 
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		return dim;
	}
	
	public static void getAvailableScreenSizes(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();

		// Get size of each screen
		for (int i = 0; i < gs.length; i++){
		    DisplayMode dm = gs[i].getDisplayMode();
		    int screenWidth = dm.getWidth();
		    int screenHeight = dm.getHeight();
		    System.out.println("screenWidth: " + screenWidth + ", screenHeight: " + screenHeight);
		}
	}
	
	public static Dimension getSingleScreenSize(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		
		DisplayMode dm = gs[1].getDisplayMode();
		int screenWidth = dm.getWidth();
		int screenHeight = dm.getHeight();
		return new Dimension(screenWidth, screenHeight);
	}
	
	public static Font getFont(String name, int style, int size){
		/*
		 * name: "Arial"
		 * style: Font.BOLD
		 * size: 12pt
		 * 
		 */
		return new Font(name, style, size);
	}
	
}
