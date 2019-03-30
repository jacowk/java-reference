package za.co.reference.xsd;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidateXsd
{

	public static void main(String[] args) throws Exception
	{
		Source xsdFile = new StreamSource(new File("C:/Users/jacok/Desktop/XSD/Example 1/note.xsd"));
		Source xmlFile = new StreamSource(new File("C:/Users/jacok/Desktop/XSD/Example 1/note.xml"));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(xsdFile);
		Validator validator = schema.newValidator();
		try
		{
			validator.validate(xmlFile);
			System.out.println(xmlFile.getSystemId() + " is valid");
		}
		catch (SAXException e)
		{
			System.out.println(xmlFile.getSystemId() + " is NOT valid");
			System.out.println("Reason: " + e.getLocalizedMessage());
		}
	}
	
}
