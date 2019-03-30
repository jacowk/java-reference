package za.co.reference.xpath;

import java.io.File;
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

public class XPathTest {
	
	public static void main(String[] args) {
		try {
			Document document = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			File file = new File("C:/article3.xml");
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(file);
			
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expression = xpath.compile("//TITLE");
			Object object = expression.evaluate(document, XPathConstants.NODESET);
			
			NodeList list = (NodeList) object;
			for (int i = 0; i < list.getLength(); i++){
				System.out.println(list.item(i).getNodeName() + " " + list.item(i).getTextContent());
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		
	}

}
