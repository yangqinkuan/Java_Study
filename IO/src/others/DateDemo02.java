package others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ��������(����+String)������
 * 1��������DateInputStream
 * 2�������DateOutputStream
 * @author Administrator
 *
 */
public class DateDemo02 {
	public static void main(String[] args)  {
		try {
			//write("F:/10/11/test/data.txt");
			byte[] data = write();
			read(data);
			System.out.println(data.length);
			//read("F:/10/11/test/data.txt");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	/**
	 * ���ֽ������ȡ����+����
	 * @throws IOException 
	 */
	public static void read(byte[] src) throws IOException{
		
		//ѡ����
		DataInputStream dis = new DataInputStream(
					new BufferedInputStream(
							new ByteArrayInputStream(src))
				);
		//���� ��ȡ��˳����д��һ��
		double num1 = dis.readDouble();
		long num2 =dis.readLong();
		String str = dis.readUTF();
		dis.close();
		System.out.println(num1+num2+str);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ����+����������ֽ�����.  
	 *	
	 * @param destPath
	 * @throws IOException
	 */
	public static byte[] write() throws IOException{
		//Ŀ������
		byte[] dest = null;
		double point = 2.5;
		long num = 100L;
		String str = "��������";
		//����Դ
		
		//ѡ����
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						bos
						)
				);
		//����д��˳��Ϊ��ȡ׼��
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dest = bos.toByteArray();
		dos.close();
		return dest;
	}
}
