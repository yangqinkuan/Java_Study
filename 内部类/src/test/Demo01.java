package test;
/**
 * �����ڲ���
 * @author Administrator
 *
 */
public class Demo01 {
	//��̬�ڲ���
	private static class StaticNestedClass{
		
	}
	//��ͨ�ڲ��ࣨ��Ա�ڲ��ࣩ
	private class FieldInnerClass{
		
	}
	void sayHello(){
		//�����ڲ���(�ֲ��ڲ���)
		class LocalClass{
			
		}
		//�����ڲ���
		Runnable runnable = new Runnable() { //��������:�����������ڲ�������壻�����������ڲ����һ��ʵ��
			
			@Override
			public void run() {
				
			}
		};
		
	}
}
