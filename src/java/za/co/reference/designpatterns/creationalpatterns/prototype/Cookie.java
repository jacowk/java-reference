package za.co.reference.designpatterns.creationalpatterns.prototype;

/*
 * Prototype Class
 */
public class Cookie implements Cloneable{
	
	@Override
	public Cookie clone(){
		Cookie copy;
		try{
			copy = (Cookie)super.clone();
		}
		catch (CloneNotSupportedException unexpected){
			throw new AssertionError(unexpected);
		}
		return copy;
	}
	
}
