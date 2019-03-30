package za.co.reference.jaxp.dom;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ParseXMLWithXSD{
	
	public static void main(String[] args) throws Exception{
		ParseXMLWithXSD parseXMLWithXSD = new ParseXMLWithXSD();
		
		// build an XSD-aware SchemaFactory
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		// hook up org.xml.sax.ErrorHandler implementation.
		schemaFactory.setErrorHandler(parseXMLWithXSD.new MyErrorHandler());

		// get the custom xsd schema describing the required format for my XML files.
		Schema schemaXSD = schemaFactory.newSchema(new File("example.xsd"));

		// Create a Validator capable of validating XML files according to my custom schema.
		Validator validator = schemaXSD.newValidator();

		// Get a parser capable of parsing vanilla XML into a DOM tree
		DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		// parse the XML purely as XML and get a DOM tree represenation.
		Document document = parser.parse(new File("example.xml"));

		// parse the XML DOM tree againts the stricter XSD schema
		validator.validate( new DOMSource(document));
	}
	
	public class MyErrorHandler implements ErrorHandler{

		@Override
		public void error(SAXParseException spe) throws SAXException{
			System.out.println("Error: " + spe.getMessage());
		}

		@Override
		public void fatalError(SAXParseException spe) throws SAXException{
			System.out.println("Fatal Error: " + spe.getMessage());
		}

		@Override
		public void warning(SAXParseException spe) throws SAXException{
			System.out.println("Warning: " + spe.getMessage());
		}
		
	}

}
