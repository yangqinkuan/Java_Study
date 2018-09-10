package io.file;

import java.io.File;
import java.util.Arrays;

public class Demo05 {
	public static void main(String[] args) {
		String path = "F:/10";
		File parent = new File(path);
//		printname(parent);
		
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
	}
	public static void printname(File src){
		if(null == src || !src.exists()){
			return;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()){
			for(File sub:src.listFiles()){
				printname(sub);
			}
		}
	}
}
