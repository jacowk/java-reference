package za.co.reference.unisa.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParsing
{

	public static void main(String[] args)
	{
		//Declare references
		Document document = null;
		String xmlDocument = "resources\\policies.xml";
		
		//Parse the input document
		try
		{
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(new File(xmlDocument));
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//Retrieve the root element and show it's name
		Element root = document.getDocumentElement();
		String rootTagName = root.getTagName();
		System.out.println("The root element tag is <" + rootTagName + ">");
		
		//Display the number of policies in the document
		NodeList nodeList = root.getElementsByTagName("policy");
		int noOfPolicies = nodeList.getLength();
		System.out.println("There are " + noOfPolicies + " policies");
		
		//Find the company domain node
		NodeList domainNodes = root.getElementsByTagName("company-domain");
		Node domainNode = domainNodes.item(0);
		
		//Print it's content (the text node is the child of the element)
		System.out.println("Domain: " + domainNode.getFirstChild().getNodeValue());
		
		//List the child elements of the root node
		System.out.println("The child elements for the root are:");
		NodeList nodes = root.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++)
		{
			Node node = nodes.item(i);
			String nodeName = node.getNodeName();
			//Any spaces or line feeds between tags will be '#text' nodes
			if (!nodeName.equals("#text"))
			{
				System.out.println(nodeName);
			}
		}
	}
	
}
