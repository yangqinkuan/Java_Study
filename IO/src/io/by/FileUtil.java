package io.by;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void copyFile(String srcpath,String destpath) throws FileNotFoundException,IOException {
		copyFile(new File(srcpath),new File(destpath));
	}
	public static void copyFile(File src,File dest) throws FileNotFoundException,IOException {
		if(!src.isFile()){
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException();
		}
		//2 ѡ����
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
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
	

