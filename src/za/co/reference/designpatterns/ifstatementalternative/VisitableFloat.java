package za.co.reference.designpatterns.ifstatementalternative;

public class VisitableFloat
{

	private Float value;
	
	public VisitableFloat(Float value)
	{
		this.value = value;
	}
	
	public void accept(Visitor visitor)
	{
		visitor.visitFloat(value);
	}
	
}
