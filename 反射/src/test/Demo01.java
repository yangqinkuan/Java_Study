package test;
/**
 * 测试java.lang.Class对象的获取方式
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String path = "bean.User";
		try {
			Class clazz = Class.forName(path);
			System.out.println(clazz.hashCode());
			Class clazz2 = Class.forName(path);
			System.out.println(clazz2.hashCode());
			
			Class strClazz = String.class;
			Class strClazz2 = path.getClass();
			
			Class intClazz = int.class;
			int[] arr01 = new int[10];
			int[][] arr02 = new int[30][3];
			int[] arr03 = new int[30];
			double[] arr04 = new double[10];
			
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());
			System.out.println(arr04.getClass().hashCode());
			
			
			
			
			
			
			
			
			
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
