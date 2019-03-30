package za.co.reference.swing.jcolorchooserexample;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JColorChooserExample extends WindowDecorator implements ChangeListener{

	public JColorChooserExample(Window decoratedWindow){
		super(decoratedWindow);
		colorChooser = new JColorChooser();
		colorChooser.setColor(Color.YELLOW);
		label = new JLabel("Choose a color");
		colorChooser.getSelectionModel().addChangeListener(this);
		JPanel colorPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		colorPanel.add(colorChooser);
		labelPanel.add(label);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(colorPanel, BorderLayout.NORTH);
		mainPanel.add(labelPanel, BorderLayout.SOUTH);
		addPanel(mainPanel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
		
	}

	@Override
	public void stateChanged(ChangeEvent e){
		label.setForeground(colorChooser.getColor());
	}
	
	private JColorChooser colorChooser;
	private JLabel label;

}
