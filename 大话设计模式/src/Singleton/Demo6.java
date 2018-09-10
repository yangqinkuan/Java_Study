package Singleton;

public class Demo6 {
	private static volatile Demo6 demo;
	private Demo6(){}
	public static Demo6 get(){
		if(demo==null){
			synchronized (Demo6.class) {
				if(demo==null){
					demo = new Demo6();
				}
			}
		}
		return demo;
	}
}
