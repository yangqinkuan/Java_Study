package Facade;

public class Memory implements Hardware{

	@Override
	public void start() {
		System.out.println("�ڴ�����");
	}

	@Override
	public void shutdown() {
		System.out.println("�ڴ�ر�");
	}
	
}
