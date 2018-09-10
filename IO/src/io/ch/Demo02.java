package io.ch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 文件的写出
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//创建源
		File dest = new File("F:/10/11/test/char.txt");
		//选择流
		Writer wr = null;
		try {
			//追加文件而不是覆盖
			wr = new FileWriter(dest,true);
			//写出
			String msg = "锄禾日当午\r\n汗滴禾下土\r\n谁知盘中餐\r\n粒粒皆辛苦";
			wr.write(msg);
			wr.append("是额啊");
			wr.flush(); 
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			if(null!=wr){
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
