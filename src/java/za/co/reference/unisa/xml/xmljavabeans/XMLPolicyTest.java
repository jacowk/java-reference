package za.co.reference.unisa.xml.xmljavabeans;

import java.util.Calendar;

public class XMLPolicyTest
{
 public static void main(String args[])
 {
  Calendar policyDate = Calendar.getInstance();
  policyDate.set(2006,06,23);
  Calendar claimDate = Calendar.getInstance();
  claimDate.set(2007,10,01);
  Claim claim = new Claim("C2007-08-16-1",false,claimDate.getTime(),627.00,"Contents","Flood damage");
  Policy policy = new Policy("8374635",policyDate.getTime(),863.00,true);
  policy.addClaim(claim);
  String xmlPolicyString = policy.getXmlDocument(true);
  System.out.println(xmlPolicyString);
 }
}

