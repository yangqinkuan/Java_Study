package io.file;

import java.io.File;

/**
 * 1、路径分隔符：pathSeparator
 * 2、名称分割符:separator
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		String path = "F:/10/11/01.png";
		path = "E:"+File.separator+"10"+File.separator+"11"+File.separator+"01.png";
		
		
	}
}
