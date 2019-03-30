package za.co.reference.jaxp.sax;

import java.io.File;
import java.io.PrintStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

/* 
 * This program uses a validating SAXParserFactory
 * DTD or XML schemas (XSD) can be used to validate an XML document
 * DTD: Data Type Definition
 * XSD: XML Schema Definition
 *  
 * */
public class SAXLocalNameCountValidatingFactory{
	
	public static void main(String[] args) throws Exception{
		String filename = "";
		String schemaSource = "";
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		spf.setValidating(true);
		SAXParser saxParser = spf.newSAXParser();
		try{
			saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA); //Tell the parser which schema language to use
		}
		catch (SAXNotRecognizedException x){
			System.err.println("Error: JAXP SAXParser property not recognized: " + JAXP_SCHEMA_LANGUAGE);
			System.err.println("Check to see if parser conforms to JAXP 1.2 spec.");
			System.exit(1);
		}
		saxParser.setProperty(JAXP_SCHEMA_SOURCE, new File(schemaSource));
		
		XMLReader xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(new SAXLocalNameCount());
		xmlReader.setErrorHandler(new MyErrorHandler(System.err));
	}
	
	private static class MyErrorHandler implements ErrorHandler{
		
		MyErrorHandler(PrintStream out){
			this.out = out;
		}
		
		private String getParseExceptionInfo(SAXParseException spe){
			String systemId = spe.getSystemId();
			if (systemId == null){
				systemId = "null";
			}
			
			String info = "URI=" + systemId + " Line=" + spe.getLineNumber() + ": " + spe.getMessage();
			return info;
		}
		
		@Override
		public void error(SAXParseException spe) throws SAXException{
			throw new SAXException("Error: " + getParseExceptionInfo(spe));
		}

		@Override
		public void fatalError(SAXParseException spe) throws SAXException{
			throw new SAXException("Fatal Error: " + getParseExceptionInfo(spe));
		}

		@Override
		public void warning(SAXParseException spe) throws SAXException{
			out.println("Warning: " + getParseExceptionInfo(spe));
		}
		
		private PrintStream out;
		
	}
	
	private static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	private static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

}
