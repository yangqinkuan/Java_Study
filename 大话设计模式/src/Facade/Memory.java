package Facade;

public class Memory implements Hardware{

	@Override
	public void start() {
		System.out.println("内存启动");
	}

	@Override
	public void shutdown() {
		System.out.println("内存关闭");
	}
	
}
