package io.by;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * д���ļ�
 * 1��������ϵ File���� Ŀ�ĵ�
 * 2��ѡ����  �ļ������ OutputStream FileOutputStream
 * 3��������write����+flush
 * 4���ͷ���Դ���ر�
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		// ������ϵ File���� Ŀ�ĵ�
		File dest = new File("F:/10/11/test/b");
		//2��ѡ���� �ļ������ OutputStream FileOutputStream
		OutputStream os = null;
		//��׷�ӵ���ʽд���ļ�
		try {
			os = new FileOutputStream(dest,true);
			// 3������
			String str = "bjsxt is very good \r\n";
			//�ַ���ת�ֽ�����
			byte[] data = str.getBytes();
			os.write(data, 0, data.length);
			os.flush();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ�δ�ҵ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ�д��ʧ��");
		}finally{
			if(null!=os){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر������ʧ��  ");
				}
			}
		}
		
	}
}
