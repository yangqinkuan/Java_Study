package test;

public class Demo04 {
	public static void main(String[] args) throws Exception {
//		int a = 3;
//		System.out.println(Integer.toBinaryString(a^0xff));
		//²âÊÔÈ¡·´²Ù×÷	
//		FileSystemClassLoader loader = new FileSystemClassLoader("F:/a");
//		Class<?> c = loader.loadClass("HelloWorld");
//		System.out.println(c);
		
		DecrptClassLoader loader = new DecrptClassLoader("F:/a");
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);
	
	
	
	}
}
