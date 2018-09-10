package io.by;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 写出文件
 * 1、建立联系 File对象 目的地
 * 2、选择流  文件输出流 OutputStream FileOutputStream
 * 3、操作：write（）+flush
 * 4、释放资源：关闭
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		// 建立联系 File对象 目的地
		File dest = new File("F:/10/11/test/b");
		//2、选择流 文件输出流 OutputStream FileOutputStream
		OutputStream os = null;
		//以追加的形式写出文件
		try {
			os = new FileOutputStream(dest,true);
			// 3、操作
			String str = "bjsxt is very good \r\n";
			//字符串转字节数组
			byte[] data = str.getBytes();
			os.write(data, 0, data.length);
			os.flush();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件写出失败");
		}finally{
			if(null!=os){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("关闭输出流失败  ");
				}
			}
		}
		
	}
}
