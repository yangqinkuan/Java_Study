package thread13;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {
	public static void main(String[] args) {
		final Business business = new ConditionCommunication().new Business();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=50;i++){
					business.sub();
				}
			}
		}).start();;
		
		for(int i=1;i<=50;i++){
			business.main();
		}
		
	}
	class Business{
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		private boolean bShouldSub = true;
		//子方法
		public void sub(){
			lock.lock();
			try{
				while(!bShouldSub){
					try {
						//this.wait();
						condition.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int j=1;j<=10;j++){
					System.out.println("sub "+j);
				}
				bShouldSub = false;
				condition.signal();
				//this.notify();
			}finally {
				lock.unlock();
			}
		}
		//父方法
		public void main(){
			lock.lock();
			try{
				while(bShouldSub){
					try { 
						//this.wait();
						condition.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for(int j=1;j<=100;j++){
					System.out.println("main "+j);
				}
				bShouldSub = true;
				//this.notify();
				condition.signal();
			}finally {
				lock.unlock();
			}
		}
		
	}
}

