package io.file;

import java.io.File;
import java.io.IOException;

import org.omg.Messaging.SyncScopeHelper;

/**
 * ���õķ���
 * 1���ļ���
 * getName() �ļ�����·����
 * getPath() ·����	
 * getAbsoluteFile() ����·������Ӧ��File����
 * getAbsolutePath() ����·����
 * getParent ��Ŀ¼�����·���ĸ�Ŀ¼������Ϊnull ��.ɾ�������Ľ��
 * 2���ж���Ϣ
 * exists()
 * canWrite()
 * canRead()
 * isFile()
 * isDirectory()
 * isAbsolute(): ����ƽ̨���죬ie���̷���ͷ��������/��ͷ
 * 3������ ���ܶ�ȡ�ļ���
 * length();
 * 4��������ɾ���ļ�
 * createNewFile() �����ڴ������ļ�
 * delete() ɾ���ļ�
 * static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ�ϣ�temp) Ĭ����ʱ�ռ�
 * static createTempFile(ǰ׺�����ֽڳ�����׺Ĭ�ϣ�temp,Ŀ¼)
 * deleteOnExit() �˳������ɾ����������ɾ����ʱ�ļ�
 * 
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args)    {
		//test01();
//		test02();
		
			try {
				test03();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	public static void test03() throws IOException, InterruptedException{
		//createNewFile���� �����ڴ����µ��ļ�
		String path = "F:/10/11/02.PNG";
		File src = new File(path);
		if(!src.exists()){
			boolean flag = src.createNewFile();
			System.out.println(flag?"�ɹ�":"ʧ��");
		}
		boolean flag = src.delete();
		System.out.println(flag?"�ɹ�":"ʧ��");
		
		File temp = File.createTempFile("test", ".temp",new File("F:/10/11"));
		Thread.sleep(1000);
		temp.deleteOnExit();
	}
	
	
	
	
	//�ж���Ϣ
	public static void test02(){
		//String path = "2.txt";
		String path = "F:/10/11/01.PNG";
		File src  = new File(path);
		System.out.println("�ļ��Ƿ���ڣ�"+src.exists());
		//�Ƿ��дcanWrite()
		System.out.println("�ļ��Ƿ��д"+src.canWrite());
		
		
//		 isFile()
//		 isDirectory()
		if(src.isFile()){
			System.out.println("���ļ�");
		}else{
			System.out.println("�ļ���");
		}
		System.out.println("����Ϊ��"+src.length());
	}
	
	//������Ϣ	
	public static void test01(){
		File src = new File("E:/10/11/01.png");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getParent());//�����ϼ�Ŀ¼���������ԣ�����NULL
		
	}
	
	
}
