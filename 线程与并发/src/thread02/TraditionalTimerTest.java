package thread02;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing");
			}
		}, 10000,3000);
		/*class MyTimerTask extends TimerTask{

			@Override
			public void run() {
				System.out.println("booming");
				new Timer().schedule(new MyTimerTask(), 2000);
			}
			
		}
		new Timer().schedule(new MyTimerTask(), 2000);
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
	}
	
}
