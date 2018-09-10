package io.util;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
	/**
	 * ������ر���
	 * �ɱ������...ֻ���β����һ��λ��,����ʽ������һ��
	 */
	public static void close(Closeable ... io){
		for(Closeable temp:io){
			try {
				if(null!=temp){
					
						temp.close();
					
				}
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * ʹ�÷��ͷ���
	 */
	public static <T extends Closeable> void closeALL(T ... io){
		for(Closeable temp:io){
			try {
				if(null!=temp){
					
						temp.close();
					
				}
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
