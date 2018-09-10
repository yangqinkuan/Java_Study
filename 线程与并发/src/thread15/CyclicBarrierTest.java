package thread15;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3);
		for(int i=0;i<3;i++){
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
				try{
					Thread.sleep((long)(Math.random()*10000));
					System.out.println("线程" + Thread.currentThread().getName() +
							"即将到达集合点1,当前已有"+(cb.getNumberWaiting()+1)+"threads");
					cb.await();
					
					Thread.sleep((long)(Math.random()*10000));
					System.out.println("线程" + Thread.currentThread().getName() +
							"即将到达集合点2,now has"+(cb.getNumberWaiting()+1)+"threads");
					cb.await();
					Thread.sleep((long)(Math.random()*10000));
					System.out.println("线程" + Thread.currentThread().getName() +
							"即将到达集合点3,now has"+(cb.getNumberWaiting()+1)+"threads");
				}catch(Exception e){
					e.printStackTrace();
					}
				}
			};
			service.execute(runnable);
		}
	}
}
