package za.co.reference.swing.multipledocumentinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MultipleDocumentInterfaceExample{
	
	public MultipleDocumentInterfaceExample(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		//Create a JFrame, or make this a JFrame
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setLocation(new Point(100, 100));
		frame.setTitle("JFrame");
		
		//Add JDesktop to JFrame
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBackground(Color.LIGHT_GRAY);
		frame.add(desktop);
		
		//Add JInternalFrames to JDesktopPane
		JInternalFrame internalFrameOne = new JInternalFrame();
		internalFrameOne.setPreferredSize(new Dimension(200, 100));
		internalFrameOne.setTitle("JInternalFrameOne");
		internalFrameOne.setLocation(new Point(10, 10));
		desktop.add(internalFrameOne);
		internalFrameOne.pack();
		internalFrameOne.setVisible(true);
		
		JInternalFrame internalFrameTwo = new JInternalFrame();
		internalFrameTwo.setPreferredSize(new Dimension(200, 100));
		internalFrameTwo.setTitle("JInternalFrameTwo");
		internalFrameTwo.setLocation(new Point(100, 100));
		desktop.add(internalFrameTwo);
		internalFrameTwo.pack();
		internalFrameTwo.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run(){
				new MultipleDocumentInterfaceExample();
			}
			
		});
	}

}