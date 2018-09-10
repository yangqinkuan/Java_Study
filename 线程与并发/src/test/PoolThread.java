package test;

public class PoolThread extends Thread{
	private BlockingQueue<Runnable> taskQueue = null;
	private boolean isStopped = false;
	public PoolThread(BlockingQueue<Runnable> queue){
		taskQueue = queue;
	}
	
	@Override
	public void run() {
		while(!isStopped){
			try {
				Runnable runnable = taskQueue.dequeue();
				runnable.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void toStop(){
		isStopped = true;
		this.interrupt();
	}
	
	public synchronized boolean isStopped(){
		return isStopped;
	}
}
