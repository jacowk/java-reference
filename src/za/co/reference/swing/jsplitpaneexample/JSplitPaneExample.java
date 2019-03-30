package za.co.reference.swing.jsplitpaneexample;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JSplitPaneExample extends WindowDecorator{

	public JSplitPaneExample(Window decoratedWindow){
		super(decoratedWindow);
		JTextArea topTextArea = new JTextArea("Top Text Area");
		JScrollPane topScrollPane = new JScrollPane(topTextArea);
		
		JTextArea bottomTextArea = new JTextArea("Bottom Text Area");
		JScrollPane bottomScrollPane = new JScrollPane(bottomTextArea);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setTopComponent(topScrollPane);
		splitPane.setBottomComponent(bottomScrollPane);
		splitPane.setDividerLocation(100); 
        splitPane.setPreferredSize(new Dimension(500, 300));
		
		
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		panel.add(splitPane);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

}
