package AIO;

public class TimeClient {
	public static void main(String[] args) {
		int port = 8080;
		try {
			port = Integer.valueOf(args[0]);
		} catch (Exception e) {
			//����Ĭ��ֵ
		}
		new Thread(new AsyncTimeClientHandler("127.0.0.1",port)).start();

	}
	
}
