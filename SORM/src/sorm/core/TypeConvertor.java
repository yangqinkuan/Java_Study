package sorm.core;
/**
 * ����java�������ͺ����ݿ��������͵Ļ���ת��
 * @author Administrator
 *
 */
public interface TypeConvertor {
	/**
	 * �����ݿ�����ת����java����������
	 * @param columnType ���ݿ��ֶε���������
	 * @return java����������
	 */
	public String databaseType2JavaType(String columnType);
	/**
	 * ��java��������ת�������ݿ���������
	 * @param javaDataType java��������
	 * @return ���ݿ���������
	 */
	public String javaType2DatabaseType(String javaDataType);
	

}
