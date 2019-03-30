package za.co.reference.swing.test;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

//Bug: http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4888144

public class TFTest extends JFrame implements DocumentListener{

	public TFTest() {
        super( "TFTest" );

        JPanel mp = new JPanel();
        mp.setLayout( new BoxLayout( mp, BoxLayout.Y_AXIS ));

        for (int i=0; i < 2; i++) {
            JPanel fp = new JPanel();
            fp.add( new JLabel( "Field " + (i+1) + ": ", SwingConstants.RIGHT ));
            JTextField tf = makeTextField();
            tf.getDocument().addDocumentListener( this );
            fp.add( tf );
            mp.add(fp);
        }
       
        getContentPane().add( mp );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }



    private JTextField
    makeTextField() {

        JFormattedTextField ftf;

        ftf = new JFormattedTextField( new DecimalFormat("0.####"));
        ftf.setColumns( 10 );

        try {
            ftf.setValue( new Double( "5.43212345" ));
        }
        catch ( Exception ex ) {}

        return ftf;
    }



    ////////// DocumentListener //////////

    public void
    changedUpdate(DocumentEvent e) {

        System.out.println("## changedUpdate");
    }


    public void
    insertUpdate(DocumentEvent e) {

        int offset = e.getOffset();
        int length = e.getLength();

        System.out.println("## insertUpdate: offset, length: " +
                                            offset + ", " + length );

        try {
            Document doc = e.getDocument();
            String txt = doc.getText( offset, length );
            System.out.println("##   text: [" + txt + "]" );
        }
        catch (BadLocationException ex ) {
            System.out.println("##   Bad Location: " + ex);
        }
    }


    public void
    removeUpdate(DocumentEvent e) {

        int offset = e.getOffset();
        int length = e.getLength();

        System.out.println("## removeUpdate: offset, length: "
                                        + offset + ", " + length );
    }



    public static void
    main( String args[] ) {
        
        TFTest app = new TFTest();
        app.pack();
        app.setVisible( true );
    }
	
}