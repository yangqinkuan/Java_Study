package Adapter;


public class test {
	public static void main(String[] args) {
		
		Tool tool = new Tool("·çÉÈ");
		Target voltage = new Adapter();
		tool.use(voltage.getvoltage());
	}
}
