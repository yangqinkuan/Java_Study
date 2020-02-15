package NIO;

public class TimeClient {
	public static void main(String[] args) {
		int port = 8080;
		if(args != null && args.length>0){
			try {
				port = Integer.valueOf(args[0]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for(int i=0;i<100;i++){
			System.out.println(i);
			MultiplexerTimeClient timerClient = new MultiplexerTimeClient("192.168.1.103",port);
			
			new Thread(timerClient).start();
		}
		
	}
}
