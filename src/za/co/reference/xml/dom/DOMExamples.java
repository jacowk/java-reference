package za.co.reference.xml.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMExamples{
	
	private void createDomXmlParser(){
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		    
		try{
		    DocumentBuilder builder = builderFactory.newDocumentBuilder();
		    parseXML(builder);
		}
		catch (ParserConfigurationException e){
		    e.printStackTrace();  
		}
	}
	
	private void parseXML(DocumentBuilder builder ){
		try{
		    Document document = builder.parse(new FileInputStream("data\\text.xml"));
		    documentObjectExamples(document);
		}
		catch (SAXException e){
		    e.printStackTrace();
		}
		catch (IOException e){
		    e.printStackTrace();
		}
	}
	
	private void documentObjectExamples(Document document){
		//A document element
		Element rootElement = document.getDocumentElement();

		//Child elements
		NodeList nodes = rootElement.getChildNodes();

		for(int i=0; i<nodes.getLength(); i++){
		  Node node = nodes.item(i);

		  if (node instanceof Element){
		    //a child element to process
		    Element child = (Element) node;
		    String attribute = child.getAttribute("width"); //Getting an ettribute
		  }
		}
	}
	
	private void schemaValidation(Document document) throws Exception{
		//Load an XML Schema
		Schema schema = null;
		try{
		  String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		  SchemaFactory factory = SchemaFactory.newInstance(language);
		  schema = factory.newSchema(new File("some file"));
		}
		catch (Exception e){
		    e.printStackTrace();
		}
		
		//Validate the schema
		Validator validator = schema.newValidator();
		validator.validate(new DOMSource(document));



	}

}
