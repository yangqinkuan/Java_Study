package reflect;

import serverdemo03.Servlet;

/**
 * ����ʵ��
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz=Class.forName("serverdemo03.LoginServlet");
		//���ÿչ���
		Servlet ser = (Servlet)clz.newInstance();
	}
}
