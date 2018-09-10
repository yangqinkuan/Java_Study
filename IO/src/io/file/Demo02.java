package io.file;

import java.io.File;

/**
 *���·�������·������File����
 * 1�����·��
 * File(String parent,String child)
 * File(File parent,String child)
 * 2������·��
 * File(String name);	
 * 
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String parentPath = "E:/10/11";
		String name = "01.png";
		//���·��
		File src = new File(parentPath,name);
		src = new File(new File(parentPath),name);
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//����·��
		src = new File("E:/10/11/01.png");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//û���̷�����user.dir����
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		
		
	}
}
