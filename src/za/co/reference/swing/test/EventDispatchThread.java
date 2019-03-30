package za.co.reference.swing.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class EventDispatchThread extends JFrame{
	
	public EventDispatchThread(){
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		
		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		JTextField textField = new JTextField();
		textField.addFocusListener(new EventListener());
		textField.setPreferredSize(new Dimension(78, 20));
		mainPanel.add(textField);
		String[] entries = { "One", "Two", "Three" };
		JComboBox combobox = new JComboBox(entries);
		combobox.setPreferredSize(new Dimension(78, 20));
		mainPanel.add(combobox);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(78, 60));
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run(){
				new EventDispatchThread();
			}
			
		});
	}
	
	private class EventListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent event){}

		@Override
		public void focusLost(FocusEvent event){
			JOptionPane.showMessageDialog(null, "Test");
		}
		
	}

}