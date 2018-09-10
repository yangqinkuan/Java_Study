package Command.Demo01;
/**
 * 命令发送者
 * @author Administrator
 *
 */
public class CommandTest {
	public static void main(String[] args) {
		//命令接受者
		Tv myTv = new Tv();
		//开机命令
		CommandOn on = new CommandOn(myTv);
		//关机命令
		CommandOff off = new CommandOff(myTv);
		//频道切换命令
		CommandChannel channel = new CommandChannel(myTv, 2);
		//命令控制对象
		Control control = new Control(on, off, channel);
		//开机
		control.turnOn();
		//切换频道
		control.changeChannel();
		//关机
		control.turnOff();
	}
}
