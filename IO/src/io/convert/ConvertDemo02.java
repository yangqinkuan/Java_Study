package io.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ת����:�ֽ�תΪ�ַ�
 * 1���������OutputStreamWriter	 ����
 * 2��������: InputStreamReader	����
 * @author Administrator
 *
 */
public class ConvertDemo02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
		new InputStreamReader( 
			new FileInputStream(
					new File("F:/10/11/test/FileUtil.java")),"UTF-8")   
				);
		//д���ļ�
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("F:/10/11/test/qqq.java")
				);
		String info = null;
		while(null!=(info=br.readLine())){
			bw.write(info);	
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}

}

