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
	//�����л�
	public static void read(String destPath) throws	IOException, ClassNotFoundException{
		//����Դ
		File src = new File(destPath);
		//ѡ����
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
	
	//���л�
	public static void seri(String destPath) throws IOException{
		Employee emp  = new Employee("bjsxt",1000000);
		//����Դ
		File dest = new File(destPath);
		//ѡ����
		ObjectOutputStream dos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//����д����˳�� Ϊ��ȡ׼��
		dos.writeObject(emp);
		//�ͷ���Դ
		dos.close();
		
	}
}
