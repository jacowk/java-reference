package za.co.reference.swing.jinternalframeexample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

public class JInternalFrameExample extends JFrame{

	public JInternalFrameExample(){
		super("JInternalFrameExample");
		JDesktopPane desktop = new JDesktopPane();
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		JInternalFrame internalFrameOne = new JInternalFrame("Frame One",
			true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
		internalFrameOne.setSize(new Dimension(300, 300));
		internalFrameOne.setLocation(20, 20);
		internalFrameOne.setVisible(true);
		
		JInternalFrame internalFrameTwo = new JInternalFrame("Frame Two",
				true, //resizable
	              true, //closable
	              true, //maximizable
	              true);//iconifiable);
		internalFrameTwo.setSize(new Dimension(300, 300));
		internalFrameTwo.setLocation(40, 40);
		internalFrameTwo.setVisible(true);
		try{
			internalFrameTwo.setSelected(true);
		}
		catch(PropertyVetoException pve){
			pve.printStackTrace();
		}
		
		desktop.add(internalFrameTwo);
		desktop.add(internalFrameOne);
		desktop.setBackground(Color.WHITE);
		
		setContentPane(desktop);
	}
	
	private static void createAndShowGUI(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
		JInternalFrameExample internalFrameExample = new JInternalFrameExample();
		BorderLayout borderLayout = new BorderLayout();
		internalFrameExample.setLayout(borderLayout);
		internalFrameExample.setTitle("JInternalFrame Example");
//		internalFrameExample.setPreferredSize(new Dimension(500, 500));
		internalFrameExample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		internalFrameExample.setLocation(50, 50); //To centre the window
		
		int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        internalFrameExample.setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
		
//		internalFrameExample.pack();
		internalFrameExample.setVisible(true);
	}

	public static void main(String[] args){
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

	}

}
