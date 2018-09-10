package test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �����ļ�ϵͳ�м��ܺ��Class�ֽ�����������
 * @author Administrator
 *
 */
public class DecrptClassLoader extends ClassLoader{
	
	//
	private String rootDir;

	public DecrptClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		//Ӧ���Ȳ�ѯ��û�м��ع�����ࡣ����Ѿ����أ���ֱ�ӷ��ؼ��غõ��ࡣ���û�У�������µ��ࡣ
		if(c!=null){
			return c;
		}else{
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name);
			} catch (Exception e) {
//				e.printStackTrace();
			} //ί�ɸ��������
			if(c!=null){
				return c;
			}else{
				byte[] classData = getClassData(name);
				if(classData==null){
					throw new ClassNotFoundException();
				}else{
					c = defineClass(name, classData, 0, classData.length);
				}
			}
			
		}
		return c;
	}
	private byte[] getClassData(String classname){
		  String path = rootDir+"/"+ classname.replace(".", "/")+".class";
		  InputStream is = null;
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();
		  try {
			 is  = new FileInputStream(path);
			 
			 int temp = -1;
				while((temp=is.read())!=-1){
					baos.write(temp^0xff);
				}
			 return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(baos!=null){
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		  
		  
	}
}
