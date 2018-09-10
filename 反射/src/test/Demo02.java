package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射的API，获取类的信息（类的名字‘属性’方法‘构造器等）
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "bean.User";
		try {
			Class clazz = Class.forName(path);
			//获取类的名字
			System.out.println(clazz.getName());//包名+类名
			System.out.println(clazz.getSimpleName());//类名
			//获取属性信息
			//Field[] fields = clazz.getFields();//只能获取PUBLIC属性
			Field[] fields = clazz.getDeclaredFields();
			Field f = clazz.getDeclaredField("uname");
			System.out.println(fields.length);
			for (Field temp : fields) {
				System.out.println("属性： "+temp);
			}
			
			
			//获取方法信息
			Method[] methods = clazz.getDeclaredMethods();
			Method m01 = clazz.getDeclaredMethod("setUname", String.class);//如果方法有参数，则必须传入参数类型对应的Class对象
			Method m02 = clazz.getDeclaredMethod("getUname", null);
			for (Method m : methods) {
				System.out.println("方法"+m);
			}
			
			//获取构造器信息
			Constructor[] constructors = clazz.getDeclaredConstructors();
			Constructor c = clazz.getDeclaredConstructor(null);
			for (Constructor temp : constructors) {
				System.out.println("构造器："+temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
