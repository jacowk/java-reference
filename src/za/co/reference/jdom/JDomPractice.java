package za.co.reference.jdom;

import java.io.File;
import java.io.IOException;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JDomPractice {
	
	public static void main(String[] args) {
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document document = saxBuilder.build(new File("person.xml"));
			Element root = document.getRootElement();
			Element name = root.getChild("name");
			System.out.println(name.getName() + ", " + name.getValue());
			Attribute company = name.getAttribute("company");
			System.out.println(company.getName() + ", " + company.getValue());
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
