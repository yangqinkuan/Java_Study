package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import bean.User;

/**
 * 通过反射API动态的操作：构造器、方法、属性
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class Demo03 {
	public static void main(String[] args) {
		String path = "bean.User";
		try {
			Class<User> clazz = (Class<User>)Class.forName(path);
			
			//获取构造器信息
			//Constructor[] constructors = clazz.getDeclaredConstructors();
			//通过反射API调用构造方法、构造对象
			User u = clazz.newInstance();
			System.out.println(u);
			Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			User u2 = c.newInstance(1001,18,"的的2");
			System.out.println(u2.getUname());
			
			//通过反射API调用普通方法
			User u3 = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3,"aa3");
			System.out.println(u3.getUname());
			
			//通过反射API操作属性
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
