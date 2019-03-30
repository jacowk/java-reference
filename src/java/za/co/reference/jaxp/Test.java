package za.co.reference.jaxp;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Test extends DefaultHandler{
	
	public static void main(String[] args) throws Exception{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		SAXParser saxParser = spf.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(new Test());
		xmlReader.parse("C:\\test.xml");
	}
	
	public void startDocument() throws SAXException{
		
	}
	
	public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) 
		throws SAXException{
		System.out.println("qualifiedName: " + qualifiedName);
	}
	
	public void characters(char[] ch, int start, int len) throws SAXException{
		String output = new String(ch, start, len);
		System.out.println("output: " + output);
	}
	
	public void endDocument() throws SAXException{
		
	}

}
