package za.co.reference.unisa.xml.xmlencoder;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class XMLEncoderTest
{
public static void main(String args[])
{
  Calendar cal = Calendar.getInstance();
  cal.set(2007,12,21);
  Claim claim = new Claim("C2007-08-16-1",false,cal.getTime(),627.00,"Contents","Flood damage");
  Policy policy = new Policy("8374635",new Date(),863.00,true);
  policy.addClaim(claim);
  try
  {
   XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("output/policy.xml")));
   encoder.writeObject(policy);
   encoder.close();
  }
  catch(IOException e)
  {
   e.printStackTrace();
  }
 }
}

