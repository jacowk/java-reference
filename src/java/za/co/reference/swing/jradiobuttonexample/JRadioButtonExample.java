package za.co.reference.swing.jradiobuttonexample;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JRadioButtonExample extends WindowDecorator implements ItemListener{

	public JRadioButtonExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		panel.setLayout(borderLayout);
		
		JPanel checkBoxPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS);
		checkBoxPanel.setLayout(boxLayout);
		birdRadioButton.addItemListener(this);
		dogRadioButton.addItemListener(this);
		catRadioButton.addItemListener(this);
		fishRadioButton.addItemListener(this);
		checkBoxPanel.add(birdRadioButton);
		checkBoxPanel.add(dogRadioButton);
		checkBoxPanel.add(catRadioButton);
		checkBoxPanel.add(fishRadioButton);
		
		ButtonGroup petButtonGroup = new ButtonGroup();
		petButtonGroup.add(birdRadioButton);
		petButtonGroup.add(dogRadioButton);
		petButtonGroup.add(catRadioButton);
		petButtonGroup.add(fishRadioButton);
		
		panel.add(checkBoxPanel, BorderLayout.NORTH);
		panel.add(selectedItemsTextArea, BorderLayout.CENTER);
		
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

	@Override
	public void itemStateChanged(ItemEvent itemEvent){
		Object source = itemEvent.getSource();
		if (source == birdRadioButton){
			if (birdRadioButton.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nBird selected");
			}
		}
		else if (source == dogRadioButton){
			if (dogRadioButton.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nDog selected");
			}
		}
		else if (source == catRadioButton){
			if (catRadioButton.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nCat selected");
			}
		}
		else if (source == fishRadioButton){
			if (fishRadioButton.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nFish selected");
			}
		}
	}
	
	private JRadioButton birdRadioButton = new JRadioButton("Bird");
	private JRadioButton dogRadioButton = new JRadioButton("Dog");
	private JRadioButton catRadioButton = new JRadioButton("Cat");
	private JRadioButton fishRadioButton = new JRadioButton("Fish");
	private JTextArea selectedItemsTextArea = new JTextArea();

}
