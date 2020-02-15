package thread04;

import java.util.Arrays;

public class TraditionalThreadCommunication {
	public static void main(String[] args) {
		final Business business = new TraditionalThreadCommunication().new Business();
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
		
		private boolean bShouldSub = true;
		//子方法
		public synchronized void sub(){
			while(!bShouldSub){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j=1;j<=10;j++){
				System.out.println("sub "+j);
			}
			bShouldSub = false;	
			this.notify();
		}
		//父方法
		public synchronized void main(){
				while(bShouldSub){
					try { 
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j=1;j<=100;j++){
					System.out.println("main "+j);
				}
				bShouldSub = true;
				this.notify();
		}
		
	}
}

