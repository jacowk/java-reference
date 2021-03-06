package za.co.reference.swing.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DocumentListenerTestWithJFormattedTextField extends JFrame{
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run(){
				new DocumentListenerTestWithJFormattedTextField();
			}
			
		});
	}
	
	public DocumentListenerTestWithJFormattedTextField(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		setTitle("Root Window");
		setPreferredSize(new Dimension(500, 100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		Panel mainPanel = new Panel();
//		mainPanel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		mainPanel.setLayout(boxLayout);
		getContentPane().add(mainPanel);
		mainPanel.add(addPanelOne());
		mainPanel.add(addPanelTwo());
		pack();
		setLocationRelativeTo(null); //To centre the window
		setVisible(true);
	}
	
	private JPanel addPanelOne(){
		JPanel panel = new JPanel();
		EmptyBorder border = new EmptyBorder(5,5,5,5);
		panel.setBorder(border);
		topText = new JFormattedTextField();
		topText.setPreferredSize(new Dimension(200, 20));
		topText.getDocument().addDocumentListener(eventListener);
		panel.add(topText);
		return panel;
	}
	
	private JPanel addPanelTwo(){
		JPanel panel = new JPanel();
		bottomText = new JFormattedTextField();
		bottomText.setPreferredSize(new Dimension(200, 20));
		panel.add(bottomText);
		return panel;
	}
	
	private class EventListener implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent event){
			System.out.println("DocumentListenerTest.EventListener.changedUpdate()");
			bottomText.setText("Changed: " + topText.getText());
		}

		@Override
		public void insertUpdate(DocumentEvent event){
			System.out.println("DocumentListenerTest.EventListener.insertUpdate()");
			bottomText.setText("Inserted: " + topText.getText());
		}

		@Override
		public void removeUpdate(DocumentEvent event){
			System.out.println("DocumentListenerTest.EventListener.removeUpdate()");
			bottomText.setText("Removed: " + topText.getText());
		}
		
	}
	
	private JFormattedTextField topText;
	private JFormattedTextField bottomText;
	private EventListener eventListener = new EventListener();

}