package za.co.reference.jaxp.dom;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DOMEcho{
	
	public static void main(String[] args) throws Exception{
		String filename = "test.xml";
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //returns non-validating parser
		dbf.setNamespaceAware(true);
		dbf.setValidating(true); //Perform validation on request
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		//Set error handler
		OutputStreamWriter errorWriter = new OutputStreamWriter(System.err, outputEncoding);
		db.setErrorHandler(new MyErrorHandler(new PrintWriter(errorWriter, true)));
		
		Document doc = db.parse(new File(filename));
	}
	
	private static class MyErrorHandler implements ErrorHandler{
		
		MyErrorHandler(PrintWriter out){
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
		
		private PrintWriter out;
		
	}
	
	private static final String outputEncoding = "UTF-8";

}
