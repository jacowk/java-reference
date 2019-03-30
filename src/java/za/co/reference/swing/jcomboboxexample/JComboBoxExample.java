package za.co.reference.swing.jcomboboxexample;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JComboBoxExample extends WindowDecorator implements ActionListener{

	public JComboBoxExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel comboBoxPanel = new JPanel();
		String values[] = {null, "Horse", "Dog", "Cat", "Pig"};
		JComboBox comboBox = new JComboBox(values);
		comboBox.setSelectedIndex(2);
		comboBox.setActionCommand("combobox");
		comboBox.addActionListener(this);
		comboBox.setEditable(false); //Set to true to make the combobox editable
		comboBoxPanel.add(comboBox);
		comboBoxPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel labelPanel = new JPanel();
		selectionLabel = new JLabel(comboBox.getSelectedItem().toString());
		selectionLabel.setFont(new Font("Arial", Font.BOLD, 12));
		labelPanel.add(selectionLabel);
		labelPanel.setBorder(new EmptyBorder(5, 0, 5, 5));
		
		panel.add(comboBoxPanel);
		panel.add(labelPanel);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

	@Override
	public void actionPerformed(ActionEvent event){
		if (event.getActionCommand().equals("combobox")){
			selectionLabel.setText(((JComboBox)event.getSource()).getSelectedItem().toString());
		}
	}
	
	private JLabel selectionLabel;

}
