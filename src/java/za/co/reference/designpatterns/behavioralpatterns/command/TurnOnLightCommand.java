package za.co.reference.designpatterns.behavioralpatterns.command;

public class TurnOnLightCommand implements Command{

	public TurnOnLightCommand(Light light){
		this.theLight = light;
	}
	
	@Override
	public void execute(){
		theLight.turnOn();
	}
	
	private Light theLight;
	
}
