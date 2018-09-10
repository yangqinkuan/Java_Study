package others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型(基本+String)处理流
 * 1、输入流DateInputStream
 * 2、输出流DateOutputStream
 * @author Administrator
 *
 */
public class DateDemo01 {
	public static void main(String[] args)  {
		try {
			//write("F:/10/11/test/data.txt");
			read("F:/10/11/test/data.txt");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	/**
	 * 从文件读取数据+类型
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException{
		//创建源
		File src = new File(destPath);
		//选择流
		DataInputStream dis = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(src))
				);
		//操作 读取的顺序与写出一致
		double num1 = dis.readDouble();
		long num2 =dis.readLong();
		String str = dis.readUTF();
		System.out.println(num1+num2+str);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 数据+类型输出到文件.  
	 *	
	 * @param destPath
	 * @throws IOException
	 */
	public static void write(String destPath) throws IOException{
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		//创建源
		File dest = new File(destPath);
		//选择流
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//操作写出顺序为读取准备
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dos.close();
	}
}
