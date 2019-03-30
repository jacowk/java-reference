package za.co.reference.swing.jtextpaneexample;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

/*
 * JEditorPanes does not require a StyledDocument interface.
 * To support a custom text format, implement an editor kit that can read, write, and edit text of that 
 * format. Then call the registerEditorKitForContentType method to register your kit with the JEditorPane 
 * class. By registering an editor kit in this way, all editor panes and text panes in your program will be 
 * able to read, write, and edit the new format. However, if the new editor kit is not a StyledEditorKit, 
 * text panes will not support the new format.
 * 
 *  Through the API provided in the JTextPane class, you can embed images and components in a text pane. 
 *  You can embed images in an editor pane, too, but only by including the images in an HTML or RTF file. 
 */
public class JEditorPaneExample extends WindowDecorator{

	public JEditorPaneExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		JScrollPane scrollPane = createEditorPane();
		panel.add(scrollPane);
		addPanel(panel);
	}
	
	private JScrollPane createEditorPane(){
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		java.net.URL contentURL = JEditorPaneExample.class.getResource("TextSamplerDemoHelp.html");
		try{
			editorPane.setPage(contentURL);
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		return scrollPane;
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}
	
	
}
