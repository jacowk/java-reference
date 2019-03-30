package za.co.reference.xml.stax;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXExamples{
	
	private void xmlInputFactoryExample() throws Exception{
		XMLInputFactory factory = XMLInputFactory.newInstance();
		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true); //May or may set different properties
		XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("data\\test.xml"));
		XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader("data\\test.xml"));	
	}
	
	private void xmlOutputFactoryExample() throws Exception{
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		factory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
		XMLEventWriter eventWriter = factory.createXMLEventWriter(new FileWriter("data\\test.xml"));
		XMLStreamWriter streamWriter = factory.createXMLStreamWriter(new FileWriter("data\\test.xml"));
	}
	
	private void xmlEventReaderExample() throws Exception{ //Provide Iterator style API for parsing XML
		XMLInputFactory factory = XMLInputFactory.newInstance();
		//get Reader connected to XML input from somewhere..
		Reader reader = getXmlReader();
		XMLEventReader eventReader = null;
		try{
		    eventReader = factory.createXMLEventReader(reader);
		}
		catch (XMLStreamException e){
		    e.printStackTrace();
		}
		
		//Iterate through the xml input
		while(eventReader.hasNext()){
		    XMLEvent event = eventReader.nextEvent();
		    if(event.getEventType() == XMLStreamConstants.START_ELEMENT){
		        StartElement startElement = event.asStartElement(); //or asEndElement() or asCharacters
		        System.out.println(startElement.getName().getLocalPart());
		    }
		    //handle more event types here...
		}
	}
	
	private void xmlEventWriterExample(){
		XMLOutputFactory factory      = XMLOutputFactory.newInstance();
		XMLEventFactory  eventFactory = XMLEventFactory.newInstance();

		try {
		    XMLEventWriter writer =
		            factory.createXMLEventWriter(
		                    new FileWriter("data\\output.xml"));

		    XMLEvent event = eventFactory.createStartDocument();
		    writer.add(event);

		    event = eventFactory.createStartElement(
		            "jenkov", "http://jenkov.com", "document");
		    writer.add(event);

		    event = eventFactory.createNamespace(
		            "jenkov", "http://jenkov.com");
		    writer.add(event);

		    event = eventFactory.createAttribute
		            ("attribute", "value");
		    writer.add(event);

		    event = eventFactory.createEndElement(
		            "jenkov", "http://jenkov.com", "document");
		    writer.add(event);

		    writer.flush();
		    writer.close();
		}
		catch (XMLStreamException e) {
		    e.printStackTrace();
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	private void xmlStreamReaderExample() throws Exception{ /* Cursor style API for parsing XML, like ResultSet */
		XMLInputFactory factory = XMLInputFactory.newInstance();

		//get Reader connected to XML input from somewhere..
		Reader reader = getXmlReader();

		try {

		    XMLStreamReader streamReader =
		        factory.createXMLStreamReader(reader);
		    
		} catch (XMLStreamException e) {
		    e.printStackTrace();
		}
		
		//Iterate through the XML input
		XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader("data\\test.xml"));
		
		while(streamReader.hasNext()){
		    streamReader.next();
		    if(streamReader.getEventType() == XMLStreamReader.START_ELEMENT){
		        System.out.println(streamReader.getLocalName());
		    }
		}
	}
	
	private void xmlStreamWriter(){
		//Write to a Writer, an OutputStream or a Result
		XMLOutputFactory factory      = XMLOutputFactory.newInstance();
		 try{
		     XMLStreamWriter writer = factory.createXMLStreamWriter(
		             new FileWriter("data\\output2.xml"));

		     writer.writeStartDocument();
		     writer.writeStartElement("document");
		     writer.writeStartElement("data");
		     writer.writeAttribute("name", "value");
		     writer.writeEndElement();
		     writer.writeEndElement();
		     writer.writeEndDocument();

		     writer.flush();
		     writer.close();

		 }
		 catch (XMLStreamException e){
		     e.printStackTrace();
		 }
		 catch (IOException e){
		     e.printStackTrace();
		 }
	}
	
	private Reader getXmlReader(){
		//TODO: How do you do this
		return null;
	}

}
