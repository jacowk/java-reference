package za.co.reference.designpatterns.ifstatementalternative;

import java.util.Collection;

public class PrintVisitor implements Visitor
{

	@Override
	public void visitCollection(Collection collection)
	{
		System.out.println("Visiting the collection");
	}

	@Override
	public void visitString(String string)
	{
		System.out.println("Visiting the string");
	}

	@Override
	public void visitFloat(Float aFloat)
	{
		System.out.println("Visiting the float");
	}

}
