package Adapter;

public class Adapter extends China implements Target{

	@Override
	public int getvoltage() {
		System.out.println("得到电压"+this.chinagetvoltage()+"返回电压"+110);
		return 110;
	}


}
