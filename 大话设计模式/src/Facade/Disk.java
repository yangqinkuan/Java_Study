package Facade;

public class Disk implements Hardware{

	@Override
	public void start() {
		System.out.println("Ӳ������");
	}

	@Override
	public void shutdown() {
		System.out.println("Ӳ�̹ر�");
	}

}
