package za.co.reference.designpatterns.ifstatementalternative;

public class VisitableString implements Visitable
{

	private String value;
	
	public VisitableString(String value)
	{
		this.value = value;
	}
	
	@Override
	public void accept(Visitor visitor)
	{
		visitor.visitString(value);
	}

}
