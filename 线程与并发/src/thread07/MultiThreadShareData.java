package thread07;

public class MultiThreadShareData {
	public static void main(String[] args) {
		
		final ShareData1 data1 = new ShareData1();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				data1.decrement();
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				data1.increment();
			}
		}).start();
		
		
		//将共享数据封装在另一个对象中，然后将这个对象逐一传递给各个Runnable对象
		final ShareData1 data2 = new ShareData1();
		new Thread(new MyRunnable1(data2)).start();
		new Thread(new MyRunnable2(data2)).start();
	}
	
	
	
}

class MyRunnable1 implements Runnable{
	
	private ShareData1 data1;
	public MyRunnable1(ShareData1 data1){
		this.data1 = data1;
	}
	@Override
	public void run() {
		data1.decrement();
	}
	
}

class MyRunnable2 implements Runnable{
	
	private ShareData1 data1;
	public MyRunnable2(ShareData1 data1){
		this.data1 = data1;
	}
	@Override
	public void run() {
		data1.increment();
	}
	
}


class ShareData1{
	private int j = 0;
	
	public synchronized void increment(){
		j++;
	}
	
	public synchronized void decrement(){
		j--;
	}
	private int count = 100;
	
}
