package za.co.reference.jaxp;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class TestXML extends DefaultHandler{
	
	public static void main(String[] args) throws Exception{
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		saxParserFactory.setNamespaceAware(true);
		SAXParser saxParser = saxParserFactory.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(new TestXML());
		xmlReader.parse("C:\\test.xml");
	}
	
	public void startDocument() throws SAXException{
		
	}
	
	public void endDocument() throws SAXException{
		
	}
	
	public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) 
	throws SAXException{
		if (localName.equals("firstname")){
			firstname = true;
		}
		else if (localName.equals("surname")){
			surname = false;
		}
	}
	
	public void characters(char[] chars, int start, int len){
		String output = new String(chars, start, len);
		if (firstname){
			System.out.println("Firstname: " + output);
		}
		else if (surname){
			System.out.println("Surname: " + output);
		}
	}
	
	private boolean firstname;
	private boolean surname;

}
