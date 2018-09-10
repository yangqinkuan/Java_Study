package Facade;

public class ComputerFacade implements Hardware{
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	public ComputerFacade() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.disk = new Disk();
	}

	@Override
	public void start() {
		cpu.start();
		memory.start();
		disk.start();
	}

	@Override
	public void shutdown() {
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
	}
	
}
