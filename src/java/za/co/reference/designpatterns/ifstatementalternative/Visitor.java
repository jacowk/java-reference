package za.co.reference.designpatterns.ifstatementalternative;

import java.util.Collection;

/* http://www.javaworld.com/article/2077602/learn-java/java-tip-98--reflect-on-the-visitor-design-pattern.html */
public interface Visitor
{
	
	public void visitCollection(Collection collection);
	
	public void visitString(String string);
	
	public void visitFloat(Float aFloat);

}
