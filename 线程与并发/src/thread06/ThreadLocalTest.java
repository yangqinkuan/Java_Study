package thread06;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public class ThreadLocalTest {
	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				
				
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+"has put data:"+data);
					x.set(data);
					/*MyThreadScopeData myData = new MyThreadScopeData();
					myData.setName("name"+data);
					myData.setAge(data);*/
					
					MyThreadScopeData.getInstance().setName("name"+data);
					MyThreadScopeData.getInstance().setAge(data);
					new A().get();
					new B().get(); 
				}
			}).start();
		}
	}
	
	static class A{
		public void get(){
			int data = x.get();
			System.out.println("A from"+Thread.currentThread().getName()
					+"get data:"+data);
			/*MyThreadScopeData myData = myThreadScopeData.get();
			myData.getName();
			myData.getAge();*/
			
			MyThreadScopeData myData = MyThreadScopeData.getInstance();
			System.out.println("A from"+Thread.currentThread().getName()
					+"name:"+myData.getName()+"age:"+myData.getAge());
		}
	}
	
	static class B{
		public void get(){
			int data = x.get();
			
			System.out.println("B from"+Thread.currentThread().getName()
					+"get data:"+data);
			MyThreadScopeData myData = MyThreadScopeData.getInstance();
			System.out.println("B from"+Thread.currentThread().getName()
					+"name:"+myData.getName()+"age:"+myData.getAge());
		}
	}

}


class MyThreadScopeData{
	private MyThreadScopeData(){};
	public static /*synchronized*/ MyThreadScopeData getInstance(){
		MyThreadScopeData instance = map.get();
		if(instance==null){
			instance = new MyThreadScopeData();
			map.set(instance);
		}
		return instance;
	}
	/*private static MyThreadScopeData instance = null;*/
	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
