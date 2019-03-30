package za.co.reference.swing.jtabbedpaneexample;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JTabbedPaneExample extends WindowDecorator{

	public JTabbedPaneExample(Window decoratedWindow){
		super(decoratedWindow);
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel panelOne = createTestPanel("Test Panel 1");
		tabbedPane.addTab("Tab 1", panelOne);
		
		JPanel panelTwo = createTestPanel("Test Panel 2");
		tabbedPane.addTab("Tab 2", panelTwo);
		
		JPanel panelThree = createTestPanel("Test Panel 3");
		tabbedPane.addTab("Tab 3", panelThree);
		
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		panel.add(tabbedPane);
		addPanel(panel);
	}
	
	private JPanel createTestPanel(String text){
		JLabel label = new JLabel(text);
		label.setFont(new Font("Arial", Font.BOLD, 14));
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		panel.add(label);
		return panel;
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

}
