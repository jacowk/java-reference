package za.co.reference.practice.comparable;

//http://lkamal.blogspot.com/2008/07/java-sorting-comparator-vs-comparable.html

/*
 * A comparable object is capable of comparing itself with another object. The class itself must implements the java.lang.Comparable interface in order to be able to compare its instances.
 * A comparator object is capable of comparing two different objects. The class is not comparing its instances, but some other class’s instances. This comparator class must implement the java.util.Comparator interface.
 * 
 * java.lang.Comparable: int compareTo(Object o1)
This method compares this object with o1 object. Returned int value has the following meanings.
1.positive – this object is greater than o1
2.zero – this object equals to o1
3.negative – this object is less than o1

java.util.Comparator: int compare(Object o1, Objecto2)
This method compares o1 and o2 objects. Returned int value has the following meanings.
1.positive – o1 is greater than o2
2.zero – o1 equals to o2
3.negative – o1 is less than o1

java.util.Collections.sort(List) and java.util.Arrays.sort(Object[]) methods can be used to sort using natural ordering of objects.
java.util.Collections.sort(List, Comparator) and java.util.Arrays.sort(Object[], Comparator) methods can be used if a Comparator is available for comparison.

 * 
 */
public class PracticeComparator{
	
	

}
