package za.co.reference.rmi.example2;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client extends JFrame {
	  TextField t1 = new TextField(30);
	  TextField t2 = new TextField(30);
	  Label rs = new Label("Sum= 0");
	  JButton b = new JButton("Add");
	  Panel p = new Panel(new GridLayout(4, 1, 5, 5));
	  RemoteInterface s;

	  public Client() {
	    super("Client Side");
	    setSize(250, 250);
	    setLocation(300, 300);
	    getContentPane().add(p, "North");
	    p.add(t1);
	    p.add(t2);
	    p.add(rs);
	    p.add(b);

	    try {
	      String ipp = JOptionPane
	      .showInputDialog("Please enter the IP Address to Connect");
	      String ip = "rmi://" + ipp + "/RMIAPPLICATION";
	      s = (RemoteInterface) Naming.lookup(ip);

	    } catch (Exception exp) {
	      JOptionPane.showMessageDialog(null, exp.getMessage());
	    }

	    b.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	        int a = Integer.parseInt(t1.getText());
	        int b = Integer.parseInt(t2.getText());
	        try {
	          int r = s.add(a, b);
	          rs.setText("Sum of two no =" + r);
	        } catch (Exception epx) {
	        }
	      }
	    });
	  }

	  public static void main(String args[]) {
	    Client c = new Client();
	    c.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    c.setVisible(true);
	  }
	} 