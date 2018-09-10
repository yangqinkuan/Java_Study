package thread13;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeConditionCommunication {
	public static void main(String[] args) {
		final Business business = new ThreeConditionCommunication().new Business();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=50;i++){
					business.sub2();
				}
			}	
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=50;i++){
					business.sub3();
				}
			}
		}).start();
		
		for(int i=1;i<=50;i++){
			business.main();
		}
		
	}
	class Business{
		Lock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		private int ShouldSub = 1;
		//子方法
		public void sub2 (){
			lock.lock();
			try{
				while(ShouldSub!=2){
					try {
						//this.wait();
						condition2.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int j=1;j<=20;j++){
					System.out.println("sub2 "+j);
				}
				ShouldSub = 3;
				condition3.signal();
				//this.notify();
			}finally {
				lock.unlock();
			}
		}
		
		//子方法
				public void sub3(){
					lock.lock();
					try{
						while(ShouldSub!=3){
							try {
								//this.wait();
								condition3.await();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						for(int j=1;j<=10;j++){
							System.out.println("sub3 "+j);
						}
						ShouldSub = 1;
						condition1.signal();
						//this.notify();
					}finally {
						lock.unlock();
					}
				}
		//父方法
		public void main(){
			lock.lock();
			try{
				while(ShouldSub!=1){
					try { 
						//this.wait();
						condition1.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for(int j=1;j<=10;j++){
					System.out.println("main "+j);
				}
				ShouldSub = 2;
				//this.notify();
				condition2.signal();
			}finally {
				lock.unlock();
			}
		}
		
	}
}

