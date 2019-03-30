package za.co.reference.xml.sax;

import java.util.ArrayList;
import java.util.List;

public class Driver{
	
	public String toString(){
        return this.driverId + " : " + this.name + " : " + this.vehicles;
    }
    
    public String driverId = null;
    public String name = null;
    public List<Vehicle> vehicles = new ArrayList<Vehicle>();

}
