package others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectDemo01 {
	public static void main(String[] args) throws ClassNotFoundException  {
		try {
			read("F:/10/11/test/ser.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//反序列化
	public static void read(String destPath) throws	IOException, ClassNotFoundException{
		//创建源
		File src = new File(destPath);
		//选择流
		ObjectInputStream dis = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
		Object obj = dis.readObject();
		if(obj instanceof Employee){
			Employee emp = (Employee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
		}
		dis.close();
		
	}
	
	//序列化
	public static void seri(String destPath) throws IOException{
		Employee emp  = new Employee("bjsxt",1000000);
		//创建源
		File dest = new File(destPath);
		//选择流
		ObjectOutputStream dos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//操作写出的顺序 为读取准备
		dos.writeObject(emp);
		//释放资源
		dos.close();
		
	}
}
