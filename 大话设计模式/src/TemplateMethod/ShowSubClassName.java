package TemplateMethod;
/**
 * ���ඨ��÷���ִ�����̣��������ʵ���Լ��ķ���
 * @author Administrator
 *
 */
public abstract class ShowSubClassName {
	/**
	 * ���������ʵ�֣����ǽ����������
	 */
	public abstract void showName();
	public void show(){
		showName();
	}
}
