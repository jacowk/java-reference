package za.co.reference.designpatterns.structuralpatterns.facade;

public class Computer{
	
	public void startComputer(){
		cpu.freeze();
		cpu.jump(12, null);
		cpu.execute();
		memory.load(41, null);
		harddrive.read(123, 123);
	}
	
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	private Harddrive harddrive = new Harddrive();

}
