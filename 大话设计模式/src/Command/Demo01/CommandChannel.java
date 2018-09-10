package Command.Demo01;
/**
 * ªª∆µµ¿√¸¡Ó
 * @author Administrator
 *
 */
public class CommandChannel implements Command{
	private Tv myTv;
	private int channel;
	
	public CommandChannel(Tv tv, int channel) {
		this.myTv = tv;
		this.channel = channel;
	}

	@Override
	public void execute() {
		myTv.changeChannel(channel);
	}

}
