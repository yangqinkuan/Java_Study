package Adapter;

public class Adapter extends China implements Target{

	@Override
	public int getvoltage() {
		System.out.println("�õ���ѹ"+this.chinagetvoltage()+"���ص�ѹ"+110);
		return 110;
	}


}
