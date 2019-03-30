package za.co.reference.xpath.example1;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathDemo{
	
	public static void main(String[] args){
		//Create a vitual representation of the XML document
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		
		DocumentBuilder documentBuilder = null;
		try{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		}
		catch (ParserConfigurationException pce){
			pce.printStackTrace();
		}
		
		Document document = null;
		try{
			document = documentBuilder.parse("C:/persons.xml");
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		catch (SAXException saxe){
			saxe.printStackTrace();
		}
		
		//Use XPath
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression xpathExpression = null;
		Object object = null;
		try{
			xpathExpression = xpath.compile("/information/person[last()]/@id");
//			xpathExpression = xpath.compile("//person[@id = 2]");
//			xpathExpression = xpath.compile("//*[count(*) = 3]");
//			xpathExpression = xpath.compile("//*[starts-with(name(),'a')]");
//			xpathExpression = xpath.compile("//*[contains(name(),'a')]");
//			xpathExpression = xpath.compile("//*[string-length(name()) = 3]");
//			xpathExpression = xpath.compile("//*[string-length(name()) > 3]");
//			xpathExpression = xpath.compile("//age | //name");
//			xpathExpression = xpath.compile("/information/person/age | /information/person/name");
//			xpathExpression = xpath.compile("/information");
//			xpathExpression = xpath.compile("/child::information");
//			xpathExpression = xpath.compile("/information/person");
//			xpathExpression = xpath.compile("/child::information/child::person");
//			xpathExpression = xpath.compile("/information/person/descendant::*");
//			xpathExpression = xpath.compile("/information/person/descendant::name");
//			xpathExpression = xpath.compile("//name/parent::*");
//			xpathExpression = xpath.compile("//name/ancestor::*");
//			xpathExpression = xpath.compile("/information/person[1]/following-sibling::*/@id");
//			xpathExpression = xpath.compile("/information/person[2]/preceding-sibling::*/@id");
//			xpathExpression = xpath.compile("/information/person[1]/following::*");
//			xpathExpression = xpath.compile("/information/person[2]/preceding::*");
//			xpathExpression = xpath.compile("/information/person[2]/descendant-or-self::*");
//			xpathExpression = xpath.compile("/information/person[2]/ancestor-or-self::*");
//			xpathExpression = xpath.compile("/information/person[2]/ancestor::*");
//			xpathExpression = xpath.compile("/information/person[2]/self::*");
			
			object = xpathExpression.evaluate(document, XPathConstants.NODESET);
		}
		catch (XPathExpressionException xpee){
			xpee.printStackTrace();
		}
		
		//Display the result returned by XPath
		NodeList nodeList = (NodeList)object;
		for (int i = 0; i < nodeList.getLength(); i++){
			System.out.println(nodeList.item(i).getNodeName() + ": " + nodeList.item(i).getNodeValue());
		}
	}
	
//	public static void main(String[] args) throws ParserConfigurationException, SAXException, 
//    	IOException, XPathExpressionException{
//		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
//		domFactory.setNamespaceAware(true); 
//		DocumentBuilder builder = domFactory.newDocumentBuilder();
//		Document doc = builder.parse("persons.xml");
//		XPath xpath = XPathFactory.newInstance().newXPath();
//		
//		// XPath Query for showing all nodes value
//		XPathExpression expr = xpath.compile("//person/*/text()");
//	
//		Object result = expr.evaluate(doc, XPathConstants.NODESET);
//		NodeList nodes = (NodeList) result;
//		for (int i = 0; i < nodes.getLength(); i++) {
//			System.out.println(nodes.item(i).getNodeValue()); 
//		}
//	}
	
}
