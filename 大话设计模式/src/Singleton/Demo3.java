package Singleton;

public class Demo3 {
	private static Demo3 demo;
	private Demo3(){}
	public static synchronized Demo3 get(){
		if(demo==null){
			demo = new Demo3();
		}
		return demo;
	}
}
