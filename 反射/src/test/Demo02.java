package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ���÷����API����ȡ�����Ϣ��������֡����ԡ��������������ȣ�
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "bean.User";
		try {
			Class clazz = Class.forName(path);
			//��ȡ�������
			System.out.println(clazz.getName());//����+����
			System.out.println(clazz.getSimpleName());//����
			//��ȡ������Ϣ
			//Field[] fields = clazz.getFields();//ֻ�ܻ�ȡPUBLIC����
			Field[] fields = clazz.getDeclaredFields();
			Field f = clazz.getDeclaredField("uname");
			System.out.println(fields.length);
			for (Field temp : fields) {
				System.out.println("���ԣ� "+temp);
			}
			
			
			//��ȡ������Ϣ
			Method[] methods = clazz.getDeclaredMethods();
			Method m01 = clazz.getDeclaredMethod("setUname", String.class);//��������в���������봫��������Ͷ�Ӧ��Class����
			Method m02 = clazz.getDeclaredMethod("getUname", null);
			for (Method m : methods) {
				System.out.println("����"+m);
			}
			
			//��ȡ��������Ϣ
			Constructor[] constructors = clazz.getDeclaredConstructors();
			Constructor c = clazz.getDeclaredConstructor(null);
			for (Constructor temp : constructors) {
				System.out.println("��������"+temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
