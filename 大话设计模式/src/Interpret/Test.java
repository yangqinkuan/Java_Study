package Interpret;

public class Test {
	private static Expression ex;
	private static Context con;
	public static void main(String[] args) {
		con = new Context();
		//���ñ���,����
		Variable a = new Variable();
		Variable b = new Variable();
		Constant c = new Constant(2);
		//Ϊ������ֵ
		con.addValue(a, 5);
		con.addValue(b, 7);
		//����,�Ծ��ӵĽṹ�������Լ�������������
		ex = new Division(new Multiply(a, b), new Add(new SuBTract(a, b), c));
		System.out.println("������Ϊ:" + ex.interpret(con));
	}
	
}
