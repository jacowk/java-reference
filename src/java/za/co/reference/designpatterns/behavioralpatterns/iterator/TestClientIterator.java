package za.co.reference.designpatterns.behavioralpatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class TestClientIterator  {
	public static void main(String[] args) { 
		ArrayList<Object> al = new ArrayList<Object>(); 
		al.add(new Integer(42)); 
		al.add(new String("test")); 
		al.add(new Double("-12.34")); 
		for(Iterator<Object> iter=al.iterator(); 
		iter.hasNext();) 
		System.out.println( iter.next() ); 
		// JEE5 syntax 
		for(Object o:al) 
		System.out.println( o ); 
	} 
}
