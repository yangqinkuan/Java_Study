package sorm.utils;
/**
 * ��װ�˷��䳣�ò���
 * @author kuan
 *
 */
public class StringUtils {
	/**
	 * ��Ŀ���ַ�������ĸ��Ϊ��д
	 * @param str	Ŀ���ַ���
	 * @return ����ĸ��Ϊ��д���ַ���
	 */
	public static String firstChar2UpperCase(String str){
		
		return str.toUpperCase().substring(0,1)+str.substring(1);
	}
}
