package test;

import java.lang.reflect.Method;

import bean.User;

public class Demo06 {
	public static void test01(){
		User u = new User();
		long startTime = System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			u.getUname();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("��ͨ�������ã�ִ��10�ڴΣ���ʱ��"+(endTime-startTime)+"ms");
		}
	public static void test02() throws Exception{
		User u = new User();
		Class clazz = u.getClass();
		Method m = clazz.getDeclaredMethod("getUname", null);
		long startTime = System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			m.invoke(u, null);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("���䶯̬�������ã�ִ��10�ڴΣ���ʱ��"+(endTime-startTime)+"ms");
		
	}
	public static void test03() throws Exception{
		User u = new User();
		Class clazz = u.getClass();
		Method m = clazz.getDeclaredMethod("getUname", null);
		m.setAccessible(true);
		long startTime = System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			m.invoke(u, null);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("���䶯̬�������ã�������ȫ��飬ִ��10�ڴΣ���ʱ��"+(endTime-startTime)+"ms");
		
	}
	public static void main(String[] args) throws Exception {
		test01();
		test02();
		test03();
	}
}
