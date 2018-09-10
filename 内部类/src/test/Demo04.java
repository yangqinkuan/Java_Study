package test;
/**
 * 测试方法内部类（局部内部类）
 * @author Administrator
 *
 */
public class Demo04 {
	
}
class Outer04{
	public void test(){
		int a = 3;
		class Inner{
			int b = 10;
		}
		Inner i = new Inner();
	}
	void test2(){
		
	}
}
