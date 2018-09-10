package others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



/**
 * 1、文件--程序-字节数组
 * 2、字节数组--程序-文件
 * 
 * @author Administrator
 *
 */
public class ByteArrayDemo02 {
	public static void main(String[] args) throws IOException {
		byte[] data = getBytesFromFile("F:/10/11/test/a.txt");
		toFileFromByteArray(data,"F:/10/11/test/e.txt");
		
	}
	/**
	 * 字节数组-程序-文件
	 * @param srcPath
	 * @return
	 * @throws IOException
	 */
	public static void toFileFromByteArray(byte[] src,String destPath) throws IOException{
		//创建源
		//创建目的地
		File dest = new File(destPath);
		//选择流
		//字节数组输入流
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//文件输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		// 操作 ， 不断地读取字节数组
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush))){
			//写出到文件中
			os.write(flush, 0, len);
		}
		os.flush();
		
		os.close();
		is.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
		
	/*
	 * 1、文件--程序-字节数组、
	 */
	public static byte[] getBytesFromFile(String srcPath) throws IOException{
		//创建文件源
		File src = new File(srcPath);
		
		//创建目的地
		byte[] dest = null;
		//选择流
		//文件输入流
		InputStream is = new BufferedInputStream(new FileInputStream(src)); 
		//字节数组输出流不能使用多态
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		//操作  不断地读取文件写出到字节数组流中
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush))){
			//写出到字节数组流中
			bos.write(flush, 0, len);
		}
		bos.flush();
		//获取数据
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
		
		
		
	}
}
