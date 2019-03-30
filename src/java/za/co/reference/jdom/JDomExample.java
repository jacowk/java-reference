package za.co.reference.jdom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class JDomExample {
	
	public static void main(String[] args) {
		JDomExample jDomExample = new JDomExample();
//		jDomExample.readXmlFile();
//		jDomExample.setAttribute();
//		jDomExample.addAttributes();
//		jDomExample.convertAttributeValueType();
		jDomExample.addChildElements();
	}
	
	private void readXmlFile(){
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(new File("person.xml"));
			Element rootElement = document.getRootElement();
			
			Element nameElement = rootElement.getChild("name");
			System.out.println(nameElement.getName() + ", " + nameElement.getValue());
			
			Attribute attribute = nameElement.getAttribute("company");
			System.out.println(attribute.getName() + ", " + attribute.getValue());
			
			Element ageElement = rootElement.getChild("age");
			System.out.println(ageElement.getName() + ", " + ageElement.getValue());
			
			Element dependentElement = rootElement.getChild("dependents");
			List dependentChildren = dependentElement.getChildren();
			System.out.println("Dependents:");
			for (int i = 0; i < dependentChildren.size(); i++){
				Element element = (Element) dependentChildren.get(i);
				System.out.println(element.getName() + ", " + element.getValue());
			}
		}
		catch (JDOMException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setAttribute(){
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(new File("person.xml"));
			Element rootElement = document.getRootElement();
			Element nameElement = rootElement.getChild("name");
			Attribute attribute = nameElement.getAttribute("company");
			attribute.setValue("DEF Company");
			XMLOutputter outputter = new XMLOutputter();
			outputter.output(document, System.out);
		}
		catch (JDOMException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addAttributes(){
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(new File("person.xml"));
			Element rootElement = document.getRootElement();
			Element nameElement = rootElement.getChild("name");
			Attribute phoneAttribute = new Attribute("phone", "999 8888");
			Attribute heightAttribute = new Attribute("height", "5.6");
			ArrayList arrayList = new ArrayList();
			arrayList.add(phoneAttribute);
			arrayList.add(heightAttribute);
			nameElement.setAttributes(arrayList);
			
			XMLOutputter outputter = new XMLOutputter();
			outputter.output(document, System.out);
		}
		catch (JDOMException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void convertAttributeValueType(){
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(new File("person.xml"));
			Element rootElement = document.getRootElement();
			Element dependentElement = rootElement.getChild("dependents");
			List dependentChildren = dependentElement.getChildren();
			for (int i = 0; i < dependentChildren.size(); i++){
				Element element = (Element) dependentChildren.get(i);
				Attribute ageAttribute = element.getAttribute("age");
				int age = ageAttribute.getIntValue();
				System.out.println("Age as int: " + age);
			}
		}
		catch (JDOMException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addChildElements(){
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(new File("person.xml"));
			Element root = document.getRootElement();
			ArrayList childList = new ArrayList();
			childList.add(new Element("address").setText("12 Some street"));
			childList.add(new Element("school").setAttribute("name", "Some school"));
			root.addContent(childList);
			
			XMLOutputter outputter = new XMLOutputter();
			outputter.output(document, System.out);
		}
		catch (JDOMException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addCData(){
		/*
		String xml ="Company.xml";
   File  file=new File(xml);   
   SAXBuilder builder = new SAXBuilder();
  try {
    Document doc = builder.build(file);
    Element rootElement = doc.getRootElement();
    Element empElement = rootElement.getChild("Employee");
    Element detailElement = empElement.getChild("Detail");
   CDATA cdata=new CDATA("<info>Working in RoseIndia.</info>.");
   CDATA cdata2= new CDATA("<work>Programmer</work>.");
       detailElement.setContent(cdata);
       detailElement.addContent(cdata2);   
   XMLOutputter outXML = new XMLOutputter(Format.getPrettyFormat());
       outXML.output(doc, System.out);   
       String charData = detailElement.getText();
       System.out.println("Charater data : " + charData);
        } catch (Exception ex)  {
             System.out.println("Exception : "+ex); }
       }
		*/
	}
	
	public void appendCData(){
		/*
		String xml = "Book.xml";
     File file = new File(xml);
     SAXBuilder builder = new SAXBuilder();
     try {
       Document doc = builder.build(file);
       Element rootElement = doc.getRootElement();
       Element empElement = rootElement.getChild("book");
       CDATA cdata = new CDATA(
       "<Detail>java is a programming book.</Detail>.");
       empElement.setContent(cdata);
       cdata.append("It support oops concept.");
XMLOutputter outXML = new XMLOutputter(Format.getPrettyFormat());
       outXML.output(doc, System.out);
       String charData = empElement.getText();
       System.out.println("Charater data : " + charData);
     } catch (Exception ex) {
       System.out.println("Exception : " + ex);
     }
		*/
	}

}
