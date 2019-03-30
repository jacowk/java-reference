package za.co.reference.unisa.xml.xmljavabeans;

import java.util.Date;
import java.text.*;

public class Claim implements java.io.Serializable
{
 private Policy policy;
 private String reference;
 private boolean approved;
 private Date claimDate;
 private double claimValue;
 private String claimType;
 private String description;

 public Claim()
 {
  super();
 }

 public Claim(String reference, boolean approved, Date date, double value, String type, String description)
 {
  super();
  setReference(reference);
  setApproved(approved);
  setClaimDate(date);
  setAmount(value);
  setType(type);
  setDescription(description);
 }

 public void setPolicy(Policy policy)
 {
  this.policy = policy;
 }
 
 public void setReference(String reference)
 {
   this.reference = reference;
 }

 public void setType(String type)
 {
  claimType = type;
 }

 public void setAmount(double amount)
 {
   claimValue = amount;
 }

 public void setDescription(String description)
 {
  this.description = description;
 }

 public void setApproved(boolean approved)
 {
  this.approved = approved;
 }

 public void setClaimDate(Date date)
 {
  claimDate = date;
 }
 
 public Policy getPolicy()
 {
  return policy;
 }
 
 public String getReference()
 {
  return reference;
 }
 
 public String getType()
 {
  return claimType;
 }

 public double getAmount()
 {
  return claimValue;
 }

 public String getDescription()
 {
  return description;
 }


 public boolean getApproved()
 {
  return approved;
 }

 public Date getClaimDate()
 {
  return claimDate;
 }
  
 private String getFormattedDate()
 {
   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   return dateFormat.format(getClaimDate());
 }
 
 public String getXmlDocument()
 {
  StringBuffer document = new StringBuffer();
  document.append("<?xml version=\"1.0\"?>");
  document.append(getXmlElement());
  return document.toString();
 }
 
 public String getXmlElement()
 {
  StringBuffer element = new StringBuffer();
  element.append("<claim>");
  element.append("<reference>" + getReference() + "</reference>");
  element.append("<type>" + getType() + "</type>");
  element.append("<description>" + getDescription() + "</description>");
  element.append("<amount>" + getAmount() + "</amount>");
  element.append("<approved>" + getApproved() + "</approved>");
  element.append("<date>" + getFormattedDate() + "</date>");
  element.append("</claim>");
  return element.toString();
 }
}




