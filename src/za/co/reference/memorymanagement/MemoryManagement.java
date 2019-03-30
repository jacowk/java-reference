package za.co.reference.memorymanagement;

public class MemoryManagement{
	
	public static void main(String[] args){
		Runtime runtime = Runtime.getRuntime();
		runtime.totalMemory();
		runtime.gc();
		runtime.freeMemory();
	}

}
