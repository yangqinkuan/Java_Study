package NIO;

public class TimeServer {
	public static void main(String[] args) {
		int port = 8080;
		if(args != null && args.length>0){
			try {
				port = Integer.valueOf(args[0]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		MultiplexerTimeServer timerServer = new MultiplexerTimeServer(port);
		new Thread(timerServer,"Server001").start();
	}
}
