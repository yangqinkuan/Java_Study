package thread03;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;

public class TraditionalThreadSynchronized {
	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();
	}
	
	public void init(){
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){	
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("asd");
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("zxc");
				}
			}
		}).start();
		
	}
	
	
	class Outputer{
		public void output(String name){
			int len = name.length();
			synchronized(this){
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
			}
		}
		
		public synchronized void output2(String name){
			int len = name.length();
			synchronized(this){
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
			}
		}
	}
	
	
}
