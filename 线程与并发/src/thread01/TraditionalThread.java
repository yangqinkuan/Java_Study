package thread01;

public class TraditionalThread {
	public static void main(String[] args) {
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					System.out.println("1:"+Thread.currentThread().getName());
					System.out.println("2:"+this.getName());
				}
			}
		};
		thread.start();
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					System.out.println("1:"+Thread.currentThread().getName());
   				}
				
			}
		});
		thread2.start();
	}
}
