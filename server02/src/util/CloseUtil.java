package util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的方法
 * @author Administrator
 *
 */
public class CloseUtil {
	public static void closeAll(Closeable... io){
		
			for(Closeable temp:io){
				try {
					if(null != temp	){
						temp.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

