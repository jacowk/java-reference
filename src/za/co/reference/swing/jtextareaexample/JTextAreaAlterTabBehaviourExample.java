package za.co.reference.swing.jtextareaexample;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JTextAreaAlterTabBehaviourExample  extends WindowDecorator{ 

	public JTextAreaAlterTabBehaviourExample(Window decoratedWindow){
		super(decoratedWindow);
		
//		JTextArea component = new JTextArea();
//		// Add actions
//		component.getActionMap().put(nextFocusAction.getValue(Action.NAME), nextFocusAction);
//		component.getActionMap().put(prevFocusAction.getValue(Action.NAME), prevFocusAction);
//		
//		// The actions
//		public Action nextFocusAction = new AbstractAction("Move Focus Forwards"){
//			public void actionPerformed(ActionEvent evt){
//				((Component)evt.getSource()).transferFocus();
//			}
//		};
//		
//		public Action prevFocusAction = new AbstractAction("Move Focus Backwards"){
//			public void actionPerformed(ActionEvent evt){
//				((Component)evt.getSource()).transferFocusBackward();
//			}
//		};
		
//		JPanel panel = new JPanel();
//		int rows = 20;
//		int cols = 30;
//		JTextArea textarea = new JTextArea("Initial Text", rows, cols);
//		textarea.setLineWrap(true);
//		textarea.setWrapStyleWord(true);
//		textarea.setTabSize(4);
//		panel.add(new JScrollPane(textarea));
//		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}
	
}
