package tcpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	public static void main(String[] args) throws Exception, IOException {
		//�ͻ��������뱾����20006�˿ڽ���TP����
		Socket client = new Socket("127.0.0.1",20006);
		client.setSoTimeout(10000);
		//��ȡ��������
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		//��ȡSocket�������,�����������ݵ������
		PrintStream out = new PrintStream(client.getOutputStream());
		//��ȡSocket��������,�������շ���˷��͹���������
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		boolean flag = true;
		while(flag){
			System.out.println("������Ϣ:");
			String str = input.readLine();
			//�������ݵ������
			out.println(str);
			if("bye".equals(str)){
				flag = false;
			}else{
				try{
					String echo = buf.readLine();
					System.out.println(echo);
					}catch (Exception e) {
						System.out.println("Tim out,No response");
					}
			}
		}
		input.close();
		if(client != null){
			//������캯��������������,��ر��׽���,���û�н�������,��Ȼ���ùر�
			client.close();//ֻ�ر�socket,����������������Ҳ��ر�
		}
	}
}
