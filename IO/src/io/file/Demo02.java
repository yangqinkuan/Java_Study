package io.file;

import java.io.File;

/**
 *相对路径与绝对路径构造File对象
 * 1、相对路径
 * File(String parent,String child)
 * File(File parent,String child)
 * 2、绝对路径
 * File(String name);	
 * 
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String parentPath = "E:/10/11";
		String name = "01.png";
		//相对路径
		File src = new File(parentPath,name);
		src = new File(new File(parentPath),name);
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//绝对路径
		src = new File("E:/10/11/01.png");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//没有盘符：以user.dir构建
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		
		
	}
}
