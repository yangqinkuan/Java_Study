package test;

public class Demo03 {
	public static void main(String[] args) {
		Outer03 out = new Outer03();
		Outer03.InnerClass ic = out.new InnerClass();
		ic.test();
	}
	
}
class Outer03	{
	private	int a = 3;
	int b = 10;
	public void ttt(){
		InnerClass ic = new InnerClass();  
	}
	
	
	//��Ա�ڲ���
	class InnerClass{
		void test(){
			System.out.println(a);
			System.out.println("�ڲ������"+this);
			System.out.println("�ⲿ�����"+Outer03.this);
		}
	}
}
