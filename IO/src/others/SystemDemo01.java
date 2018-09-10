package others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * ��������
 * 1��System.in	������
 * 2��System.out
 * 	  System.err
 * @author Administrator
 *==>�ض���
 *setIn()
 *setOut()
 *setErr()
 *FileDescriptor.in
 *FileDescriptor.out
 *
 */
public class SystemDemo01 {
	public static void main(String[] args) throws FileNotFoundException {
		//test01();
		//test02();
		//�ض���
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("F:/10/11/test/print.txt")),true));
		System.out.println("aaaaa");
		//�ؿ���̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("back....");
	}
	
	
	public static void test02() throws FileNotFoundException{
		InputStream is = System.in;//��������
		is = new BufferedInputStream(new FileInputStream("F:/10/11/test/print.txt"));
		Scanner sc  = new  Scanner(is);
		//System.out.println("�����룺");
		System.out.println(sc.nextLine());
	}
	
	
	
	
	public static void test01(){
		System.out.println("test");
		System.err.println("err");
	}
}
