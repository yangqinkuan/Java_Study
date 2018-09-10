package net.tcp.chat.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * @author Administrator
 *
 */
public class Server {
	private List<MyChannel> all = new ArrayList<MyChannel>(); 
	
	
	public static void main(String[] args) throws IOException {
		new Server().start();
	}
	public void start() throws IOException{
		ServerSocket server = new ServerSocket(9999);
		while(true){	
			Socket client = server.accept();
			MyChannel channel = new MyChannel(client);
			all.add(channel);
			new Thread(channel).start();
		}
	}
	
	
	
	/**
	 * 一个客户端一条道路
	 * 1、输入流
	 * 2、输出流
	 * 3、接受数据
	 * 4、发送数据
	 * @author Administrator
	 *
	 */
	private class MyChannel implements Runnable{
		private DataInputStream dis ;
		private DataOutputStream dos;
		private boolean isRunning = true;
		public MyChannel(Socket client){
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				CloseUtil.closeAll(dis,dos);
				isRunning = false;
			}
		}
		/**
		 * 读取数据
		 * @return
		 */
		private String receive(){
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CloseUtil.closeAll(dis);
				isRunning = false;
				all.remove(this);//移除自身
			}
			return msg;
		}
		/**
		 * 发送数据
		 */
		private void send(String msg){
			if(null==msg || msg.equals("")){
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				CloseUtil.closeAll(dos);
				isRunning = false;
				all.remove(this);
			}
			
		}
		/**
		 * 发送给其他客户端
		 */
		private void sendOthers(){
			String msg = receive();
			//遍历容器
			for(MyChannel other:all){
				if(other == this){
					continue;
				}
				//发送其他客户端  
				other.send(msg);
			}
		}
		
		
		public void run(){
			while(isRunning){
				 sendOthers();
			}
		}
	}
}
	
