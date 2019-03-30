package za.co.reference.swing.rootwindow;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class RootWindow extends JFrame implements Window{

	public RootWindow(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		setTitle("Root Window");
		setPreferredSize(new Dimension(500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null); //To centre the window
		setVisible(true);
	}

	@Override
	public void addPanel(JPanel panel){
		getContentPane().add(panel, BorderLayout.NORTH);
	}

}
