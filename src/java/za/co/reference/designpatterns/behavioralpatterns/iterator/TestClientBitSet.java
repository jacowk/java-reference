package za.co.reference.designpatterns.behavioralpatterns.iterator;

import java.util.BitSet;

public class TestClientBitSet { 
	public static void main(String[] args) { 
		// create BitSet and set some bits 
		BitSet bitset = new BitSet(); 
		bitset.set(1); 
		bitset.set(3400); 
		bitset.set(20); 
		bitset.set(47); 
		BitSetIterator iter = new BitSetIterator(bitset); 
		while (iter.hasNext()) { 
			Boolean b = iter.next();               
			String tf = (b.booleanValue() ? "T" : "F"); 
			System.out.print(tf); 
		} 
		System.out.println(); 
	} 
}