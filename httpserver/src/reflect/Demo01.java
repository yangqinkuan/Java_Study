package reflect;

public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		String str = "abc";
		//Class����
		//����.getClass()
		Class<?> clz = str.getClass();
		//��.class
		clz = String.class;
		//����·��
		clz=Class.forName("java.lang.String");
	}
}
