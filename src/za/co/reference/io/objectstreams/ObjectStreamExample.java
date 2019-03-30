package za.co.reference.io.objectstreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamExample{

	public static void main(String[] args){
		ObjectStreamExample objectStreamExample = new ObjectStreamExample();
		objectStreamExample.write();
		objectStreamExample.read();
	}
	
	public void write(){
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try{
			fileOutputStream = new FileOutputStream("person.tmp");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(createPerson());
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				if (fileOutputStream != null){
					fileOutputStream.close();
				}
				if (objectOutputStream != null){
					objectOutputStream.close();
				}
			}
			catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
	public void read(){
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try{
			fileInputStream = new FileInputStream("person.tmp");
			objectInputStream = new ObjectInputStream(fileInputStream);
			Person person = (Person) objectInputStream.readObject();
			System.out.println("firstname: " + person.getFirstname());
			System.out.println("surname: " + person.getSurname());
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		catch (ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		finally{
			try{
				if (fileInputStream != null){
					fileInputStream.close();
				}
				if (objectInputStream != null){
					objectInputStream.close();
				}
			}
			catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
	private Person createPerson(){
		Person person = new Person();
		person.setFirstname("John");
		person.setSurname("Doe");
		return person;
	}
	
}