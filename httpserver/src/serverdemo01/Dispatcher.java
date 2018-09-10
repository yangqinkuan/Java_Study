package serverdemo01;

import java.io.IOException;
import java.net.Socket;

import util.CloseUtil;

/**
 * һ��������һ����Ӧ��һ���˶���
 * @author Administrator
 *
 */
public class Dispatcher implements Runnable {
	private Socket client;
	private Request req;
	private Response rep;
	private int code = 200;
	
	Dispatcher(Socket client){
		this.client=client;
		try {
			req = new Request(client.getInputStream());
			rep = new Response(client.getOutputStream());
		} catch (IOException e) {
			code = 500;
			return;
		}
		
	}

	@Override
	public void run() {
		Servlet serv = new Servlet();
		serv.service(req,rep);
		//����
		
		
		
		//��Ӧ


		

		try {
			rep.pushToClient(code);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			rep.pushToClient(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CloseUtil.closeAll(client);
	}
	
}
