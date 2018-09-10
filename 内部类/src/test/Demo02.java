package test;
/**
 * 测试静态内部类的详细用法
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		Outer02.StaticInnerClass osic = new Outer02.StaticInnerClass();
		osic.test();
	}

	
}
class Outer02{
	int c = 5;
	static int d = 10;
	void ttt(){
		StaticInnerClass sic = new StaticInnerClass();
	}
	//静态内部类
		static class StaticInnerClass{
		int a = 3;
		static int b = 5;
		public void test(){
			System.out.println(b);
		}
	} 
}
