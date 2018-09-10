package test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<Runnable>{
	private List<Runnable> queue = new LinkedList<Runnable>();
	private int limit = 10;
	final Lock lock = new ReentrantLock();
	public BlockingQueue(int limit){
		this.limit = limit;
	}
	
	public void enqueue(Runnable x) throws InterruptedException{
		lock.lock();
		while(this.queue.size()==this.limit){
			wait();
		}
		if(this.queue.size() == 0){
			notifyAll();
		}
		this.queue.add(x);
		lock.unlock();
		}
	
	public Runnable dequeue() throws InterruptedException{
		while(this.queue.size()==0){
			wait();
		}
		if(this.queue.size() == this.limit){
			notifyAll();
		}
		return this.queue.remove(0);
	}
}
