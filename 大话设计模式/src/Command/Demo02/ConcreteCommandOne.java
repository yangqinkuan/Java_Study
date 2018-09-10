package Command.Demo02;

public class ConcreteCommandOne implements Command{
	private Receiver receiver;
	
	public ConcreteCommandOne(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.actionOne();
	}

}
