package io.ch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * ���ı��Ŀ���
 * @author Administrator
 *
 */
public class CopyFileDemo {
	public static void main(String[] args) {
		//����Դ
		File src = new File("F:/10/11/test/a.txt");
		File dest = new File("F:/10/11/test/d.txt");
		//ѡ����
		Reader reader=null;
		Writer wr = null;
		try {
			 reader = new FileReader(src);
			 wr = new FileWriter(dest);
			char[] flush = new char[1024];
			int len = 0;
			while(-1!=(len=reader.read(flush))){
				wr.write(flush, 0, len);
				
			}
			wr.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=wr){
				try {
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			try {
				if(null!=reader){
				reader.close();
			  }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
