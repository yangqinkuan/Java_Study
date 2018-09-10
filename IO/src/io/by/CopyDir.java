package io.by;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyDir {
	public static void main(String[] args) {
		String srcpath = "F:/10";
		
		String destpath = "F:/a";
		File src = new File(srcpath);
		File dest = new File(destpath);
		if(src.isDirectory()){
			dest = new File(destpath,src.getName());
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				System.out.println("父目录不能拷贝到子目录中");
				return;
			}
		}
		copyDirDetail(src,dest);
		
		
	}
	public static void copyDirDetail(File src,File dest){
		if(src.isFile()){
			
				try {
					FileUtil.copyFile(src, dest);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(src.isDirectory()){
				//确保目标文件存在
				dest.mkdirs();
				for(File sub:src.listFiles()){
					copyDirDetail(sub,new File(dest,sub.getName()));
				}
			}
	}
	
}
