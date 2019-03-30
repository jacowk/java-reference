package za.co.reference.generics;

public abstract class AbstractMaintainPerson<T>{

	public AbstractMaintainPerson(Class<T> dataclass){
		this.dataclass = dataclass;
		System.out.println(dataclass.toString());
	}
	
	private Class<T> dataclass;
	
}
