package pattern;
/**
 * ������
 * �����֮��Ĺ�ϵ
 * 1���������βΣ��ֲ�����
 * 2������������
 * 		�ۺϣ����� �����벿��  ��һ�µ���������
 * 		��ϣ����� �����벿�� һ�µ���������
 * 3���̳�:�������ϵ
 * 4��ʵ�֣��ӿ���ʵ����Ĺ�ϵ
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Voice v = new Voice();
		v.say();
		Amplifier am = new Amplifier(v);
		am.say();
	}
}
