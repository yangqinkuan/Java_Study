package others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo01 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("test");
		PrintStream ps = System.out;
		ps.println(false);
		
		
		//输出到文件
		File src = new File("F:/10/11/test/print.txt");
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
		ps.print("io is so easy");
		
		ps.close();
	}
}
