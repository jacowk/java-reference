package za.co.reference.xsd;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class Practice
{

	public static void main(String[] args)
	{
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try
		{
			Schema schema = factory.newSchema(new StreamSource("resources/practice.xsd"));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource("resources/practice.xml"));
			System.out.println("Successful validation");
		}
		catch (SAXException sax)
		{
			sax.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
}
