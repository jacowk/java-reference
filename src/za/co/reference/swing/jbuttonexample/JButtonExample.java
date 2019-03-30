package za.co.reference.swing.jbuttonexample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JButtonExample extends WindowDecorator implements ActionListener{

	public JButtonExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		panel.setLayout(borderLayout);
		
		JPanel checkBoxPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS);
		checkBoxPanel.setLayout(boxLayout);
		birdButton.addActionListener(this);
		birdButton.setMnemonic(KeyEvent.VK_B); //Alt + B
		dogButton.addActionListener(this);
		dogButton.setMnemonic(KeyEvent.VK_D); //Alt + D
		catButton.addActionListener(this);
		catButton.setMnemonic(KeyEvent.VK_C); //Alt + C
		fishButton.addActionListener(this);
		fishButton.setMnemonic(KeyEvent.VK_F); //Alt + F
		checkBoxPanel.add(birdButton);
		checkBoxPanel.add(dogButton);
		checkBoxPanel.add(catButton);
		checkBoxPanel.add(fishButton);
		
		panel.add(checkBoxPanel, BorderLayout.NORTH);
		panel.add(selectedItemsTextArea, BorderLayout.CENTER);
		
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();
		if (source == birdButton){
			selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nBird selected");
		}
		else if (source == dogButton){
			selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nDog selected");
		}
		else if (source == catButton){
			selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nCat selected");
		}
		else if (source == fishButton){
			selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nFish selected");
		}
	}
	
	private JButton birdButton = new JButton("Bird");
	private JButton dogButton = new JButton("Dog");
	private JButton catButton = new JButton("Cat");
	private JButton fishButton = new JButton("Fish");
	private JTextArea selectedItemsTextArea = new JTextArea();
	
}
