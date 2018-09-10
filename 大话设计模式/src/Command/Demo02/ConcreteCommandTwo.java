package Command.Demo02;

public class ConcreteCommandTwo implements Command{
	private Receiver receiver;
	
	
	public ConcreteCommandTwo(Receiver receiver) {
		this.receiver = receiver;
	}


	@Override
	public void execute() {
		receiver.actionTwo();
	}

}
