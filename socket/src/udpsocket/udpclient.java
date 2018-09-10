package udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;

public class udpclient {
	private static final int TIMEOUT = 5000;//���ý������ݵĳ�ʱʱ��
	private static final int MAXNUM = 5; //�����ط����ݵ�������
	public static void main(String[] args) throws Exception {
		String str_send = "Hello UDPserver";
		byte[] buf = new byte[1024];
		//�ͻ�����9000�˿ڼ������յ�������
		DatagramSocket ds = new DatagramSocket(9000);
		InetAddress loc = InetAddress.getLocalHost();
		//���������������ݵ�DatagramPacketʵ��
		DatagramPacket dp_send = new DatagramPacket(str_send.getBytes(), str_send.length(),loc,3000);
		//���������������ݵ�DatagramPacketʵ��
		DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
		//���ݷ��򱾵�3000�˿�
		ds.setSoTimeout(TIMEOUT); //���ý����������������ʱ��
		int tries = 0; //�ط����ݵĴ���
		boolean receivedResponse = false; //�Ƿ���յ����ݵı�ʶλ
		//ֱ���������ݣ������ط������ﵽԤ��ֵ,���˳�ѭ��
		while(!receivedResponse && tries<MAXNUM){
			//��������
			ds.send(dp_send);
			try{
				//���մӷ���˷��ͻ���������
				ds.receive(dp_receive);
				//������յ������ݲ�������Ŀ���ַ,���׳��쳣
				if(!dp_receive.getAddress().equals(loc)){
					throw new IOException("Received packet from an umknown source");
				}
				//������յ�����.��receivedResponse��־λ��Ϊtrue,�Ӷ��Ƴ�ѭ��
				receivedResponse = true;
			}catch(Exception e){
				//�����������ʱ������ʱ,�ط�������һ���ط��Ĵ���
				tries += 1;
				System.out.println("Time out," + (MAXNUM - tries) + "more tries..");
			}
		}
		if(receivedResponse){
			//����յ�����,���ӡ����
			System.out.println("client received data from server: ");
			String str_receive = new String(dp_receive.getData(),0,dp_receive.getLength())+
					"from" + dp_receive.getAddress().getHostAddress()+":"+dp_receive.getPort();
			System.out.println(str_receive);
			//����dp_receive�ڽ�������֮��,���ڲ���Ϣ����ֵ���Ϊʵ�ʽ��յ���Ϣ���ֽ� ��
			//��������Ҫ��dp_receive���ڲ���Ϣ����������Ϊ1024
			dp_receive.setLength(1024);
		}else{
			//����ط�MAXNUM�����ݺ�,��δ��÷��������ͻ���������,���ӡ������Ϣ
			System.out.println("No response -- give up");
		}
		ds.close();
	}
}
