package net.tcp.chat.demo02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ���������߳�
 * @author Administrator
 *
 */
public class Send implements  Runnable {
	//������������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	//�����̵߳ı�ʶ
	private boolean isRunning = true;
	
	
	public Send() {
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket client){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	private String getMsgFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return "";
	}
	/**
	 * 1���ӿ���̨��������
	 * 2����������
	 */
	public void send(){
		String msg = getMsgFromConsole();
			try {
				if(null!=msg && !msg.equals("")){
					dos.writeUTF(msg);
					dos.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				isRunning = false;
				CloseUtil.closeAll(dos,console);
			}
	}


	public void run() {
		//�߳���
		while(isRunning){
			send();
		}
	}


}
