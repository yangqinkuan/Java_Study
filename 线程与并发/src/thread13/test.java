package thread13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test {
	static Lock lock = new ReentrantLock();
	static int should = 1;
	public static void main(String[] args) {
		
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		
	}
	public void method(int count){
		
		while(count<=60){
			
		lock.lock();
		while(should==1){
			for(int i=0;i<5;i++){
				System.out.println();
			}
		}
		}
	}
}
