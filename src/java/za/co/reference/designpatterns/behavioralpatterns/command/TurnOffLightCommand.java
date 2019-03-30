package za.co.reference.designpatterns.behavioralpatterns.command;

public class TurnOffLightCommand implements Command{
	
	public TurnOffLightCommand(Light light){
		this.theLight = light;
	}

	@Override
	public void execute(){
		theLight.turnOff();
	}
	
	private Light theLight;

}
