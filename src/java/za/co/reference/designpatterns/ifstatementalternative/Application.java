package za.co.reference.designpatterns.ifstatementalternative;

public class Application
{
	
	public static void main(String[] args)
	{
		Visitor visitor = new PrintVisitor();
		Visitable visitable = new VisitableString("The string");
		visitable.accept(visitor);
	}

}
