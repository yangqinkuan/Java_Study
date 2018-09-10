package Singleton;

public class Demo2 {
	private static Demo2 demo = null;
	static{
		demo = new Demo2();
	}
	private Demo2(){}
	public static Demo2 get(){
		return demo;
	}
}
