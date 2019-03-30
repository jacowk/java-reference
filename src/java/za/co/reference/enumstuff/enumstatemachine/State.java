package za.co.reference.enumstuff.enumstatemachine;

public interface State{

	/**
	* @return true to keep processing, false to read more data.
	*/
	boolean process(Context context);
	
}