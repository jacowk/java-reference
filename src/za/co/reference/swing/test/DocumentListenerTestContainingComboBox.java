package za.co.reference.swing.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DocumentListenerTestContainingComboBox extends JFrame{

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run(){
				new DocumentListenerTestContainingComboBox();
			}
			
		});
	}
	
	public DocumentListenerTestContainingComboBox(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		setTitle("Test");
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
		topText = new DateTextField();
		topText.setPreferredSize(new Dimension(200, 20));
		topText.getDocument().addDocumentListener(eventListener);
		panel.add(topText);
		return panel;
	}
	
	private JPanel addPanelTwo(){
		JPanel panel = new JPanel();
		comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(200, 20));
		panel.add(comboBox);
		return panel;
	}
	
	private class EventListener implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent event){
System.out.println("DocumentListenerTestContainingComboBox.EventListener.changedUpdate()");
			comboBox.removeAllItems();
			if (topText.getText().equals("a")){
				comboBox.addItem("Apple");
				comboBox.addItem("Angel");
				comboBox.addItem("Ancestor");
			}
			else if (topText.getText().equals("b")){
				comboBox.addItem("Bee");
				comboBox.addItem("Beatle");
				comboBox.addItem("Bug");
			}
			else if (topText.getText().equals("c")){
				comboBox.addItem("Candle");
				comboBox.addItem("Can");
				comboBox.addItem("Cane");
			}
			else{
				comboBox.addItem("Something else");
				comboBox.addItem("Other stuff");
				comboBox.addItem("Who knows what");
			}
		}

		@Override
		public void insertUpdate(DocumentEvent event){
System.out.println("DocumentListenerTestContainingComboBox.EventListener.insertUpdate()");
			comboBox.removeAllItems();
			if (topText.getText().equals("a")){
				comboBox.addItem("Apple");
				comboBox.addItem("Angel");
				comboBox.addItem("Ancestor");
			}
			else if (topText.getText().equals("b")){
				comboBox.addItem("Bee");
				comboBox.addItem("Beatle");
				comboBox.addItem("Bug");
			}
			else if (topText.getText().equals("c")){
				comboBox.addItem("Candle");
				comboBox.addItem("Can");
				comboBox.addItem("Cane");
			}
			else{
				comboBox.addItem("Something else");
				comboBox.addItem("Other stuff");
				comboBox.addItem("Who knows what");
			}
		}

		@Override
		public void removeUpdate(DocumentEvent event){
System.out.println("DocumentListenerTestContainingComboBox.EventListener.removeUpdate()");
			comboBox.removeAllItems();
			if (topText.getText().equals("a")){
				comboBox.addItem("Apple");
				comboBox.addItem("Angel");
				comboBox.addItem("Ancestor");
			}
			else if (topText.getText().equals("b")){
				comboBox.addItem("Bee");
				comboBox.addItem("Beatle");
				comboBox.addItem("Bug");
			}
			else if (topText.getText().equals("c")){
				comboBox.addItem("Candle");
				comboBox.addItem("Can");
				comboBox.addItem("Cane");
			}
			else{
				comboBox.addItem("Something else");
				comboBox.addItem("Other stuff");
				comboBox.addItem("Who knows what");
			}
		}
		
	}
	
	private DateTextField topText;
	private JComboBox comboBox;
	private EventListener eventListener = new EventListener();
	
}