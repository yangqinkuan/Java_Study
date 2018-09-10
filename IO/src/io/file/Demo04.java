package io.file;

import java.io.File;
import java.io.FilenameFilter;


/**
 * 5������Ŀ¼
 * mkdir() ����Ŀ¼������ȷ�� ��Ŀ¼����
 * mkdirs() ����Ŀ¼�������Ŀ¼�����ڣ�һͬ����
 * list() �ļ�:Ŀ¼�ַ�����ʽ
 * listFiles()
 * static listRoots() ��·��
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		String path = "F:/10/11";
		File src = new File(path);
		if(src.isDirectory()){
			String[] subNames = src.list();
			for(String temp:subNames){
				System.out.println(temp);
			}
		}
		File[] subFiles = src.listFiles();
		for(File temp:subFiles){
			System.out.println(temp.getAbsolutePath());
		}
		subFiles = src.listFiles(new FilenameFilter(){

			@Override
			public boolean accept(File dir, String name) {
				System.out.println(dir.getAbsolutePath());
				return new File(dir,name).isFile()&&name.endsWith(".java");
			}
			
		});
		
		
		
		
	}
	public static void test01(){
		String path = "F:/10/11/test";
		String path01 = "F:/a/b/test";
		File src = new File(path);
		File src01 = new File(path01);
		src.mkdir();
		src01.mkdirs();
		
	}
	
	
	
	
	
}
