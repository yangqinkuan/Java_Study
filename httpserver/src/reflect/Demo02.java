package reflect;

import serverdemo03.Servlet;

/**
 * 创建实例
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz=Class.forName("serverdemo03.LoginServlet");
		//调用空构造
		Servlet ser = (Servlet)clz.newInstance();
	}
}
