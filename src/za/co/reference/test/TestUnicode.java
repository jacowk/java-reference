package za.co.reference.test;

import java.awt.FlowLayout;
import java.awt.Label;

public class TestUnicode extends java.applet.Applet {

	  public static final String COPYRIGHT  = "\u00a9";
	  public static final String REGISTERED = "\u00ae";
	  public static final String EURO = "\u20ac";

	  public void init () {
	   setLayout(new FlowLayout());
	   Label a = new Label(COPYRIGHT + " R\u00e9al Gagnon");
	   Label b = new Label(REGISTERED + " R\u00e9al's Software "
	                       + " price : 100 " + EURO);
	   add(a); 
	   add(b); 
	  }
	}

