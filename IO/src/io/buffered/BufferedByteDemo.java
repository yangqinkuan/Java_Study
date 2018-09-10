package io.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 字节流文件拷贝+缓冲流，提高性能
 * @author Administrator
 *
 */
public class BufferedByteDemo {
	public static void main(String[] args) {
		
	}
	public static void copyFile(String srcpath,String destpath) throws IOException {
		//1 建立联系源(存在且为文件) + 目的地(文件可以不存在)
		File src = new File(srcpath);
		File dest = new File(destpath);
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
