package io.by;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1��������ϵ File���� ԴͷĿ�ĵ�
 * 2��ѡ����
 * 		�ļ������� InputStream FileInputStream
 * 		�ļ������ OutputStream FileOutputStream
 * 3�������� ����
 *    byte[] flush = new byte[1024];
 *    int len=0;
 *    while(-1!=(len=������.read(flush)){
 *    	�����.write(flush,0,len)
 *    }
 *    �����.flush
 * 4���ͷ� ��Դ���ر�������
 * @author Administrator
 *
 */
public class CopyFileDemo {
	public static void main(String[] args)  {
		String src = "F:/10/11/02.png";
		String dest = "F:/10/11/03.png";
		try {
			copyFile(src,dest);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����ļ�ʧ�ܣ��ر���ʧ��");
		}
		
		
	}
	/**
	 * �ļ��Ŀ���
	 */
	public static void copyFile(String srcpath,String destpath) throws IOException {
		//1 ������ϵԴ(������Ϊ�ļ�) + Ŀ�ĵ�(�ļ����Բ�����)
		File src = new File(srcpath);
		File dest = new File(destpath);
		if(!src.isFile()){
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException();
		}
		//2 ѡ����
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		//�ļ��Ŀ��� ѭ��+��ȡ+д��
		byte[] flush = new byte[1024];
		int len=0;
		//��ȡ
		while(-1!=(len=is.read(flush))){
			//д��
			os.write(flush, 0, len);
		}
		os.flush();//ǿ��ˢ��
		//�ر��� 
		os.close();
		is.close();
	}
	
	
	
	
	
	
	
	
	
	
	
}
