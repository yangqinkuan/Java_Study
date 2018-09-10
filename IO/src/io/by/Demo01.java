package io.by;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ļ��Ķ�ȡ
 * 1��������ϵ File����
 * 2��ѡ����  �ļ������� InputStream  FileInputStream
 * 3�������� byte[] car = new byte[1024]; +read+��ȡ��С
 * 		���
 * 4���ͷ���Դ:�ر�
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//������ϵ File����
		File src = new File("F:/10/11/test/a.txt");
		//ѡ����
		InputStream is = null;//����������
		try {
			 is = new FileInputStream(src);
			 //3���������϶�ȡ,��������
			 byte[] car = new byte[10];
			 int len = 0; //����ʵ�ʶ�ȡ�Ĵ�С
			 //ѭ����ȡ
			 while(-1!=(len=is.read(car))){
				 //��� �ֽ�����ת���ַ���
				 String info = new String(car,0,len);
				 System.out.println(info);
			 }
			 
			 
			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ȡ�ļ�ʧ��");
		}finally{
			//4 �ͷ���Դ
			if(null != is){
				try {
					is.close();
				} catch (Exception e2) {
					
					System.out.println("�ر��ļ�������ʧ��");
				}
			}
		}
	}
}
