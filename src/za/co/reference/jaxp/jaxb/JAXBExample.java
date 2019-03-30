package za.co.reference.jaxp.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExample{
	
	public static void main(String[] args) throws Exception{
		JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
		
		/* Create an xml file */
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(getPerson(), new File("C:\\person.xml"));
		
		/* Load an xml file */
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Person unmarshalledPerson = (Person)unmarshaller.unmarshal(new File("C:\\person.xml"));
		System.out.println("XML Unmarshalled: " + unmarshalledPerson.getPersonalDetail().getFirstname() + " " 
			+ unmarshalledPerson.getPersonalDetail().getSurname());
	}
	
	public static Person getPerson(){
		return new Person(new PersonalDetail("John", "Doe"));
	}

}
