package za.co.reference.swing.jcheckboxexample;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JCheckBoxExample extends WindowDecorator implements ItemListener{

	public JCheckBoxExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		panel.setLayout(borderLayout);
		
		JPanel checkBoxPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS);
		checkBoxPanel.setLayout(boxLayout);
		birdCheckBox.addItemListener(this);
		dogCheckBox.addItemListener(this);
		catCheckBox.addItemListener(this);
		fishCheckBox.addItemListener(this);
		checkBoxPanel.add(birdCheckBox);
		checkBoxPanel.add(dogCheckBox);
		checkBoxPanel.add(catCheckBox);
		checkBoxPanel.add(fishCheckBox);
		
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
		if (source == birdCheckBox){
			if (birdCheckBox.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nBird selected");
			}
			else if (!birdCheckBox.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nBird deselected");
			}
		}
		else if (source == dogCheckBox){
			if (dogCheckBox.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nDog selected");
			}
			else if (!dogCheckBox.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nDog deselected");
			}
		}
		else if (source == catCheckBox){
			if (catCheckBox.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nCat selected");
			}
			else if (!catCheckBox.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nCat deselected");
			}
		}
		else if (source == fishCheckBox){
			if (fishCheckBox.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nFish selected");
			}
			else if (!fishCheckBox.isSelected()){
				selectedItemsTextArea.setText(selectedItemsTextArea.getText() + "\nFish deselected");
			}
		}
	}
	
	private JCheckBox birdCheckBox = new JCheckBox("Bird");
	private JCheckBox dogCheckBox = new JCheckBox("Dog");
	private JCheckBox catCheckBox = new JCheckBox("Cat");
	private JCheckBox fishCheckBox = new JCheckBox("Fish");
	private JTextArea selectedItemsTextArea = new JTextArea();

}
