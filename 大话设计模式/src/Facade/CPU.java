package Facade;

public class CPU implements Hardware{

	@Override
	public void start() {
		System.out.println("CPU����");
	}

	@Override
	public void shutdown() {
		System.out.println("CPU�ر�");
	}


	
}
