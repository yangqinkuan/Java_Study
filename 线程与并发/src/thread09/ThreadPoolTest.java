package thread09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		
		//ExecutorService threadPool = Executors.newFixedThreadPool(3); 固定线程池个数
		//ExecutorService threadPool = Executors.newCachedThreadPool(); 不固定线程个数
		/*ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for(int i=1;i<=10;i++){
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<10;i++){
					System.out.println(Thread.currentThread().getName()+"is loop of"+i+"for task"+task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed");
		threadPool.shutdown();*/
		
	/*	Executors.newScheduledThreadPool(3).schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombind");
			}
		}, 10, TimeUnit.SECONDS);*/
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombind");
			}
		}, 6,2, TimeUnit.SECONDS);
	}
}
