package Facade;

public class CPU implements Hardware{

	@Override
	public void start() {
		System.out.println("CPUÆô¶¯");
	}

	@Override
	public void shutdown() {
		System.out.println("CPU¹Ø±Õ");
	}


	
}
