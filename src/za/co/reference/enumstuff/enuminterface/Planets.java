package za.co.reference.enumstuff.enuminterface;

public enum Planets implements Named{

	Mercury, 
	Venus, 
	Earth, 
	Mars, 
	Jupiter, 
	Saturn, 
	Uranus, 
	Neptune;
	
	// name() is implemented automagically.
	@Override
	public int order(){
		return ordinal()+1;
	}

}