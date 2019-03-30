package za.co.reference.swing.jtextareaexample;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JTextAreaExample  extends WindowDecorator{

	public JTextAreaExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		int rows = 20;
		int cols = 30;
		JTextArea textarea = new JTextArea("Initial Text", rows, cols);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setTabSize(4);
		panel.add(new JScrollPane(textarea));
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

}
