package io.convert;

import java.io.UnsupportedEncodingException;

public class ConvertDemo01 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "�й�";
		byte[] data = str.getBytes();
		//�ֽ���������
		System.out.println(new String(data,0,3));
		
	}
	/**����������ַ���������ͬ����������
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	public static void test01() throws UnsupportedEncodingException{
		//����
				String str = "�й�";
				//����
				byte[] data = str.getBytes();
				//�����������ַ���ͳһ
				System.out.println(new String(data));
				data = str.getBytes("utf-8");//�趨�����ַ���
				//��ͳһ����������
				System.out.println(new String(data));
				byte[] data2 = "�й�".getBytes("utf-8");
				str = new String(data2,"utf-8");
				System.out.println(str);
	}
}
