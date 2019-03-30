package za.co.reference.swing.jcomboboxexample;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class CustomJComboBoxExample extends WindowDecorator{

	public CustomJComboBoxExample(Window decoratedWindow){
		super(decoratedWindow);
		//Create an array of indexes
		Integer[] intArray = new Integer[petStrings.length];
		for (int i = 0; i < petStrings.length; i++){
			intArray[i] = new Integer(i);
		}
		
		JPanel panel = new JPanel();
		ComboBoxRenderer comboBoxRenderer = new ComboBoxRenderer();
		comboBoxRenderer.setPreferredSize(new Dimension(200, 30));
		JComboBox comboBox = new JComboBox(intArray);
		comboBox.setRenderer(comboBoxRenderer);
		comboBox.setMaximumRowCount(3);
		panel.setLayout(new BorderLayout());
		panel.add(comboBox, BorderLayout.NORTH);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}
	
	public class ComboBoxRenderer extends JTextField implements ListCellRenderer{
		
		public ComboBoxRenderer(){
            setOpaque(true);
            setHorizontalAlignment(LEFT);
        }

		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus){
			int selectedIndex = ((Integer)value).intValue();
			if (isSelected){
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			}
			else{
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setText(petStrings[selectedIndex]);
			setFont(list.getFont());
			return this;
		}
		
	}
	
	private String[] petStrings = {"", "Bird", "Cat", "Dog", "Rabbit", "Pig"};

}
