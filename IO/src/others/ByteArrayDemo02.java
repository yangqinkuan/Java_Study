package others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



/**
 * 1���ļ�--����-�ֽ�����
 * 2���ֽ�����--����-�ļ�
 * 
 * @author Administrator
 *
 */
public class ByteArrayDemo02 {
	public static void main(String[] args) throws IOException {
		byte[] data = getBytesFromFile("F:/10/11/test/a.txt");
		toFileFromByteArray(data,"F:/10/11/test/e.txt");
		
	}
	/**
	 * �ֽ�����-����-�ļ�
	 * @param srcPath
	 * @return
	 * @throws IOException
	 */
	public static void toFileFromByteArray(byte[] src,String destPath) throws IOException{
		//����Դ
		//����Ŀ�ĵ�
		File dest = new File(destPath);
		//ѡ����
		//�ֽ�����������
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//�ļ������
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		// ���� �� ���ϵض�ȡ�ֽ�����
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush))){
			//д�����ļ���
			os.write(flush, 0, len);
		}
		os.flush();
		
		os.close();
		is.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
		
	/*
	 * 1���ļ�--����-�ֽ����顢
	 */
	public static byte[] getBytesFromFile(String srcPath) throws IOException{
		//�����ļ�Դ
		File src = new File(srcPath);
		
		//����Ŀ�ĵ�
		byte[] dest = null;
		//ѡ����
		//�ļ�������
		InputStream is = new BufferedInputStream(new FileInputStream(src)); 
		//�ֽ��������������ʹ�ö�̬
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		//����  ���ϵض�ȡ�ļ�д�����ֽ���������
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush))){
			//д�����ֽ���������
			bos.write(flush, 0, len);
		}
		bos.flush();
		//��ȡ����
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
		
		
		
	}
}
