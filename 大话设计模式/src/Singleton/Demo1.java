package Singleton;

public class Demo1 {
	private static final Demo1 demo1 = new Demo1();
	private Demo1(){
	}
	public static Demo1 getDemo(){
		return demo1;
	}
}
