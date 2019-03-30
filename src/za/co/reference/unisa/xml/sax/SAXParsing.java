package za.co.reference.unisa.xml.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParsing extends DefaultHandler
{

	private boolean isClaim = false;
	
	public static void main(String[] args)
	{
		String xmlDocument = "resources\\policies.xml";
		//Use an instance of ourselves as the SAX event handler
		DefaultHandler handler = new SAXParsing();
		//Use the default (non-validating) parser
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try
		{
			SAXParser saxParser = factory.newSAXParser();
			System.out.println(saxParser.isNamespaceAware());
			
			//Document to be parsed, a handler object that can respond to SAX events
			saxParser.parse(new File(xmlDocument), handler); 
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
	}
	
	public void startElement(String uri, String simpleName, String qualifiedName, Attributes a)
	{
		System.out.println("<" + qualifiedName);
		for (int i = 0; i < a.getLength(); i++)
		{
			System.out.println(" " + a.getQName(i) + "=\"" + a.getValue(i) + "\"");
		}
		System.out.println(">");
	}
	
	public void endElement(String uri, String simpleName, String qualifiedName)
	{
		System.out.println("</"+ qualifiedName + ">");
	} 
	
	public void characters(char[] ch, int start, int length)
	{
		String claimString = new String(ch);
		System.out.print(claimString.substring(start, start + length));
	}
	
}
