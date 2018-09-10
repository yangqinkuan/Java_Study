package thread14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3);
		
		for(int i=0;i<10;i++){
			Runnable runnable = new Runnable(){

				@Override
				public void run(){
				try{
					sp.acquire();
				}catch(InterruptedException e1){
					e1.printStackTrace();
				}
				System.out.println("�߳�"+Thread.currentThread().getName()+"����,��ǰ����"+(3-sp.availablePermits()) + "���߳�");
				try{
					Thread.sleep((long)(Math.random()*10000));
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("�߳�"+Thread.currentThread().getName()+"�����뿪");
				sp.release();
				System.out.println("�߳�"+Thread.currentThread().getName()+"���뿪,��ǰ����"+(3-sp.availablePermits()) + "���߳�");
				}
			};
			service.execute(runnable);
		}
	}
}
