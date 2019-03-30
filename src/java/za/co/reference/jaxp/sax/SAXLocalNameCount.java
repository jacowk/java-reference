package za.co.reference.jaxp.sax;

import java.io.File;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/*
 * This program counts the number of elements using only the localName component of the element
 */
public class SAXLocalNameCount extends DefaultHandler{
	
	public static void main(String[] args) throws Exception{
		String filename = "C:/test.xml";
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true); //Factory is set to support
		SAXParser saxParser = spf.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(new SAXLocalNameCount());
		xmlReader.setErrorHandler(new MyErrorHandler(System.err));
		xmlReader.parse(convertToFileURL(filename));
	}
	
	public void startDocument() throws SAXException{
		tags = new Hashtable();
	}
	
	public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) 
		throws SAXException{
		/* If namespace processing is not enabled, the localName could be an empty string */
		String key = localName;
		Object value = tags.get(key);
		if (value == null){
			tags.put(key, new Integer(1));
		}
		else{
			int count = ((Integer)value).intValue();
			count++;
			tags.put(key, new Integer(count));
		}
	}
	
	public void endDocument() throws SAXException{
		Enumeration e = tags.keys();
		while (e.hasMoreElements()){
			String tag = (String)e.nextElement();
			int count = ((Integer)tags.get(tag)).intValue();
			System.out.println("Local Name \"" + tag + "\" occurs " + count + " times");
		}
	}
	
	private static String convertToFileURL(String filename){
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/'){
            path = path.replace(File.separatorChar, '/');
        }
        if (!path.startsWith("/")){
            path = "/" + path;
        }
        return "file:" + path;
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

	private Hashtable tags;

}
