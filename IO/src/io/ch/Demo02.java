package io.ch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * �ļ���д��
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//����Դ
		File dest = new File("F:/10/11/test/char.txt");
		//ѡ����
		Writer wr = null;
		try {
			//׷���ļ������Ǹ���
			wr = new FileWriter(dest,true);
			//д��
			String msg = "�����յ���\r\n���κ�����\r\n˭֪���в�\r\n����������";
			wr.write(msg);
			wr.append("�Ƕ");
			wr.flush(); 
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			if(null!=wr){
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
