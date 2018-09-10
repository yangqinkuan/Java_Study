package test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 网络类类加载器
 * @author Administrator
 *
 */
public class NetClassLoader2 extends ClassLoader{
	
	//
	private String rootURL;

	public NetClassLoader2(String rootURL) {
		this.rootURL = rootURL;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		//应该先查询有没有加载过这个类。如果已经加载，则直接返回加载好的类。如果没有，则加载新的类。
		if(c!=null){
			return c;
		}else{
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name);
			} catch (Exception e) {
//				e.printStackTrace();
			} //委派给父类加载
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
		  String path = rootURL+"/"+ classname.replace(".", "/")+".class";
		  InputStream is = null;
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();
		  try {
			  URL url = new URL(path);
			  is = url.openStream();
			 byte[] buffer = new byte[1024];
			 int temp = 0;
			 while((temp=is.read(buffer))!=-1){
				 baos.write(buffer, 0, temp);
				 baos.flush();
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
