package io.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * 字符缓冲 流+新增方法
 * @author Administrator
 *
 */
public class BufferedCharDemo {
	public static void main(String[] args) {
		//创建源
		File src = new File("D:/JAVA/IO/src/io/by/FileUtil.java");
		File dest = new File("F:/10/11/test/d.txt");
		//选择流
		BufferedReader reader=null;
		BufferedWriter wr = null;
		try {
			 reader = new BufferedReader(new FileReader(src));
			 wr = new BufferedWriter(new FileWriter(dest));
			/*char[] flush = new char[1024];
			int len = 0;
			while(-1!=(len=reader.read(flush))){
				wr.write(flush, 0, len);
				
			}*/
			 String line= null;
			 while(null!=(line=reader.readLine())){
				 wr.write(line);
				 wr.append("\r\n");
				 wr.newLine();
			 }
			wr.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
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
