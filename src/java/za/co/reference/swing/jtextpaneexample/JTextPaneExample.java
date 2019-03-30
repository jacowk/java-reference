package za.co.reference.swing.jtextpaneexample;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

/*
 * JTextPane documents requires the StyledDocument interface to be implemented.
 * HTMLDocument and RTFDocument are StyledDocuments. 
 * The StyledDocument for a plaintext document is DefaultStyledDocument.
 * DefaultStyledDocument is used by default by JTextPanes.
 * A text pane also requires it's editor kit to be an instance of StyledEditorKit (like the JEditorPane)
 * 
 * Through the API provided in the JTextPane class, you can embed images and components in a text pane. 
 * You can embed images in an editor pane, too, but only by including the images in an HTML or RTF file. 
 * 
 */
public class JTextPaneExample extends WindowDecorator implements ActionListener{

	public JTextPaneExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		JScrollPane scrollPane = createTextPane();
		panel.add(scrollPane);
		addPanel(panel);
	}
	
	private JScrollPane createTextPane(){
		JTextPane textPane = new JTextPane();
		
		String[] initString =
		        { "This is an editable JTextPane, ",            //regular
		          "another ",                                   //italic
		          "styled ",                                    //bold
		          "text ",                                      //small
		          "component, ",                                //large
		          "which supports embedded components..." + newline,//regular
		          " " + newline,                                //button
		          "...and embedded icons..." + newline,         //regular
		          " ",                                          //icon
		          newline + "JTextPane is a subclass of JEditorPane that " +
		            "uses a StyledEditorKit and StyledDocument, and provides " +
		            "cover methods for interacting with those objects."
		         };
		
		String[] initStyles =
		        { "regular", "italic", "bold", "small", "large",
		          "regular", "button", "regular", "icon",
		          "regular"
		        };
		
		StyledDocument doc = textPane.getStyledDocument();
		addStylesToDocument(doc);
		
		try {
		    for (int i=0; i < initString.length; i++) {
		        doc.insertString(doc.getLength(), initString[i],
		                         doc.getStyle(initStyles[i]));
		    }
		} catch (BadLocationException ble) {
		    System.err.println("Couldn't insert initial text into text pane.");
		}
		
		
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		return scrollPane;
	}
	
	protected void addStylesToDocument(StyledDocument doc) {
        //Initialize some styles.
        Style def = StyleContext.getDefaultStyleContext().
                        getStyle(StyleContext.DEFAULT_STYLE);

        Style regular = doc.addStyle("regular", def);
        StyleConstants.setFontFamily(def, "SansSerif");

        Style s = doc.addStyle("italic", regular);
        StyleConstants.setItalic(s, true);

        s = doc.addStyle("bold", regular);
        StyleConstants.setBold(s, true);

        s = doc.addStyle("small", regular);
        StyleConstants.setFontSize(s, 10);

        s = doc.addStyle("large", regular);
        StyleConstants.setFontSize(s, 16);

        s = doc.addStyle("icon", regular);
        StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
        ImageIcon pigIcon = createImageIcon("images/Pig.gif",
                                            "a cute pig");
        if (pigIcon != null) {
            StyleConstants.setIcon(s, pigIcon);
        }

        s = doc.addStyle("button", regular);
        StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
        ImageIcon soundIcon = createImageIcon("images/sound.gif",
                                              "sound icon");
        JButton button = new JButton();
        if (soundIcon != null) {
            button.setIcon(soundIcon);
        } else {
            button.setText("BEEP");
        }
        button.setCursor(Cursor.getDefaultCursor());
        button.setMargin(new Insets(0,0,0,0));
        button.setActionCommand(buttonString);
        button.addActionListener(this);
        StyleConstants.setComponent(s, button);
    }
	
	protected static ImageIcon createImageIcon(String path,
            String description) {
		java.net.URL imgURL = TextSamplerDemo.class.getResource(path);
		if (imgURL != null) {
		return new ImageIcon(imgURL, description);
		} else {
		System.err.println("Couldn't find file: " + path);
		return null;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
        if (buttonString.equals(e.getActionCommand())) {
            Toolkit.getDefaultToolkit().beep();
        }
    }

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}
	
	private String newline = "\n";
	protected static final String buttonString = "JButton";

}
