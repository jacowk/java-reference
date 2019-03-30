package za.co.reference.unisa.xml.xmljavabeans;

import java.util.Date;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Policy
{
 private String policyNumber;
 private Date startDate;
 private double annualPremium;
 private boolean paidUp;
 private Collection<Claim> claims;

 public Policy()
 {
  super();
  claims = new ArrayList<Claim>();
 }

 public Policy(String policyNumber, Date startDate, double annualPremium, boolean paidUp)
 {
  super();
  setPolicyNumber(policyNumber);
  setStartDate(startDate);
  setAnnualPremium(annualPremium);
  setPaidUp(paidUp);
  claims = new ArrayList<Claim>();
 }

 public void setPolicyNumber(String policynumber)
 {
  policyNumber = policynumber;
 }
 
 public void setStartDate(Date startDate)
 {
  this.startDate = startDate;
 }
 
 public void setAnnualPremium(double premium)
 {
  annualPremium = premium;
 }

 public void setPaidUp(boolean paidUp)
 {
  this.paidUp = paidUp;
 }

 public void setClaims(Collection<Claim> claims)
 {
  this.claims = claims;
 }

 public String getPolicyNumber()
 {
  return policyNumber;
 }
 
 public Date getStartDate()
 {
  return startDate;
 }
 
 public double getAnnualPremium()
 {
  return annualPremium;
 }

 public boolean getPaidUp()
 {
  return paidUp;
 }

 public Collection<Claim> getClaims()
 {
  return claims;
 }
 
 public void addClaim(Claim claim)
 {
  claims.add(claim);
  claim.setPolicy(this);
 }
 
 private String getFormattedDate()
 {
  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  return dateFormat.format(getStartDate());
 }
 public String getXmlDocument(boolean graph)
 {
  StringBuffer document = new StringBuffer();
  document.append("<?xml version=\"1.0\"?>");
  document.append(getXmlElement(graph));
  return document.toString();
 }
 
 public String getXmlElement(boolean graph)
 {
  StringBuffer element = new StringBuffer();
  element.append("<policy policy-number=\"" + getPolicyNumber() + "\">");
  element.append("<start-date>" + getFormattedDate() + "</start-date>");
  element.append("<annual-premium>" + getAnnualPremium() + "</annual-premium>");
  element.append("<number-of-claims>" + claims.size() + "</number-of-claims>");
  element.append("<paid-up>" + getPaidUp() + "</paid-up>");
  if(graph)
  {
   element.append("<claims>");
   Iterator<Claim> claimIter = claims.iterator();
   while(claimIter.hasNext())
   {
    Claim claim = claimIter.next();
    element.append(claim.getXmlElement());
   }
   element.append("</claims>");
  } 
  element.append("</policy>");
  return element.toString();
 }
}