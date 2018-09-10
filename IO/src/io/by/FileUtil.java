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
			System.out.println("只能拷贝文件");
			throw new IOException();
		}
		//2 选择流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//文件的拷贝 循环+读取+写出
		byte[] flush = new byte[1024];
		int len=0;
		//读取
		while(-1!=(len=is.read(flush))){
			//写出
			os.write(flush, 0, len);
		}
		os.flush();//强制刷出
		//关闭流 
		os.close();
		is.close();
	}
}
	

