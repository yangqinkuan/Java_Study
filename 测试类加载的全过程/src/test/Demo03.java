package test;
/**
 * 测试自定义的FileSystemClassLoader
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) throws Exception {
		FileSystemClassLoader loader =new FileSystemClassLoader("F:/");
		FileSystemClassLoader loader2 =new FileSystemClassLoader("F:/");
		Class<?> c = loader.loadClass("HelloWorld");
		Class<?> c2 = loader.loadClass("HelloWorld");
		Class<?> c3 = loader2.loadClass("HelloWorld");
		Class<?> c4 = loader2.loadClass("java.lang.String");

		System.out.println(c);
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c4.getClassLoader());
		System.out.println(c3.getClassLoader());
		//只有同一个加载器加载的同一各类，才是相同的
	}
} 
