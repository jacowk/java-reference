package za.co.reference.enumstuff.enumstatemachine;

import java.nio.ByteBuffer;

public interface Context{

	ByteBuffer buffer();
	State state();
	
	void state(State state);
	
}