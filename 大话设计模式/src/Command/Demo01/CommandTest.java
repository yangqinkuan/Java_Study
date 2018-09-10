package Command.Demo01;
/**
 * �������
 * @author Administrator
 *
 */
public class CommandTest {
	public static void main(String[] args) {
		//���������
		Tv myTv = new Tv();
		//��������
		CommandOn on = new CommandOn(myTv);
		//�ػ�����
		CommandOff off = new CommandOff(myTv);
		//Ƶ���л�����
		CommandChannel channel = new CommandChannel(myTv, 2);
		//������ƶ���
		Control control = new Control(on, off, channel);
		//����
		control.turnOn();
		//�л�Ƶ��
		control.changeChannel();
		//�ػ�
		control.turnOff();
	}
}
