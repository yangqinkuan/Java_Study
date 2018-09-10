package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import bean.User;

/**
 * ͨ������API��̬�Ĳ�����������������������
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class Demo03 {
	public static void main(String[] args) {
		String path = "bean.User";
		try {
			Class<User> clazz = (Class<User>)Class.forName(path);
			
			//��ȡ��������Ϣ
			//Constructor[] constructors = clazz.getDeclaredConstructors();
			//ͨ������API���ù��췽�����������
			User u = clazz.newInstance();
			System.out.println(u);
			Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			User u2 = c.newInstance(1001,18,"�ĵ�2");
			System.out.println(u2.getUname());
			
			//ͨ������API������ͨ����
			User u3 = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3,"aa3");
			System.out.println(u3.getUname());
			
			//ͨ������API��������
			User u4 = clazz.newInstance();
			Field f = clazz.getDeclaredField("uname");
			f.setAccessible(true);
			f.set(u4, "aa4");
			System.out.println(u4.getUname());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
