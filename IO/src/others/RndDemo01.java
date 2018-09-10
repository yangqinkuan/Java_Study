package others;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import io.by.FileUtil;
/**
 * 1、分割的快数 size
 * 2、每块的大小 blockSize
 *   最后：总的文件大小-(n-1)*blockSize
 * @author Administrator
 *
 */


public class RndDemo01 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile rnd = new RandomAccessFile(new File("F:/10/11/test/a.txt"), "r");
		rnd.seek(10);
		//定义缓冲大小
		byte[] flush = new byte[1024];
		//接受长度
		int len = 0;
		while(-1!=(len=rnd.read(flush))){
			System.out.println(new String(flush,0,len));
		}
		rnd.close(); 
		
		
		
		
	}
}
