package za.co.reference.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TestXML{
	
	public static void main(String[] args){
		File stylesheet = new File("C:/article3.xsl");
		File datafile = new File("C:/article3.xml");
		
		Document document = null;
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			document = builder.parse(datafile);
			
			TransformerFactory tFactory = TransformerFactory.newInstance();
			StreamSource source = new StreamSource(stylesheet);
			Transformer transformer = tFactory.newTransformer(source);
			
			DOMSource domSource = new DOMSource(document);
			StreamResult result = new StreamResult(System.out);
			transformer.transform(domSource, result);
		}
		catch (ParserConfigurationException e){
			e.printStackTrace();
		}
		catch (SAXException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		catch (TransformerConfigurationException e){
			e.printStackTrace();
		}
		catch (TransformerException e){
			e.printStackTrace();
		}
		
	}

}
