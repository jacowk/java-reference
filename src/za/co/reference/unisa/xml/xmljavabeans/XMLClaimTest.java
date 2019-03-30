package za.co.reference.unisa.xml.xmljavabeans;

import java.util.Date;

public class XMLClaimTest
{
public static void main(String args[])
{
  Claim claim = new Claim("C2007-08-16-1",false,new Date(),627.00,"Contents","Flood damage");
  String xmlClaimString = claim.getXmlDocument();
  System.out.println(xmlClaimString);
 }
}

