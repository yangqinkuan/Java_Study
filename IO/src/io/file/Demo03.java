package io.file;

import java.io.File;
import java.io.IOException;

import org.omg.Messaging.SyncScopeHelper;

/**
 * 常用的方法
 * 1、文件名
 * getName() 文件名，路径名
 * getPath() 路径名	
 * getAbsoluteFile() 绝对路径所对应的File对象
 * getAbsolutePath() 绝对路径名
 * getParent 父目录，相对路径的父目录，可能为null 如.删除本身后的结果
 * 2、判断信息
 * exists()
 * canWrite()
 * canRead()
 * isFile()
 * isDirectory()
 * isAbsolute(): 消除平台差异，ie以盘符开头，其他以/开头
 * 3、长度 不能读取文件夹
 * length();
 * 4、创建和删除文件
 * createNewFile() 不存在创建新文件
 * delete() 删除文件
 * static createTempFile(前缀3个字节长，后缀默认，temp) 默认临时空间
 * static createTempFile(前缀三个字节长，后缀默认，temp,目录)
 * deleteOnExit() 退出虚拟机删除，常用于删除临时文件
 * 
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args)    {
		//test01();
//		test02();
		
			try {
				test03();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	public static void test03() throws IOException, InterruptedException{
		//createNewFile（） 不存在创建新的文件
		String path = "F:/10/11/02.PNG";
		File src = new File(path);
		if(!src.exists()){
			boolean flag = src.createNewFile();
			System.out.println(flag?"成功":"失败");
		}
		boolean flag = src.delete();
		System.out.println(flag?"成功":"失败");
		
		File temp = File.createTempFile("test", ".temp",new File("F:/10/11"));
		Thread.sleep(1000);
		temp.deleteOnExit();
	}
	
	
	
	
	//判断信息
	public static void test02(){
		//String path = "2.txt";
		String path = "F:/10/11/01.PNG";
		File src  = new File(path);
		System.out.println("文件是否存在："+src.exists());
		//是否可写canWrite()
		System.out.println("文件是否可写"+src.canWrite());
		
		
//		 isFile()
//		 isDirectory()
		if(src.isFile()){
			System.out.println("是文件");
		}else{
			System.out.println("文件夹");
		}
		System.out.println("长度为："+src.length());
	}
	
	//构建信息	
	public static void test01(){
		File src = new File("E:/10/11/01.png");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getParent());//返回上级目录，如果是相对，返回NULL
		
	}
	
	
}
