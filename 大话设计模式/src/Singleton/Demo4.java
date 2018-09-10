package Singleton;

public class Demo4 {
	private static class Demo4Holder{
		private static final Demo4 demo4 = new Demo4();
	}
	private Demo4(){}
	public static final Demo4 get(){
		return Demo4Holder.demo4;
	}
}
