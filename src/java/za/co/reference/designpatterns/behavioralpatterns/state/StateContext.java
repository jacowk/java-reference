package za.co.reference.designpatterns.behavioralpatterns.state;

public class StateContext {
	private State myState; 
	public StateContext() { 
		setState(new StateA()); 
	} 
 
        // normally only called by classes implementing the State interface
	public void setState(State stateName) { 
		this.myState = stateName; 
	}
 
	public void writeName(String name) { 
		this.myState.writeName(this, name); 
	} 
}
