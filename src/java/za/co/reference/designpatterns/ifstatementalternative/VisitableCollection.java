package za.co.reference.designpatterns.ifstatementalternative;

import java.util.Collection;

public class VisitableCollection
{

	private Collection value;
	
	public VisitableCollection(Collection value)
	{
		this.value = value;
	}
	
	public void accept(Visitor visitor)
	{
		visitor.visitCollection(value);
	}
	
}
