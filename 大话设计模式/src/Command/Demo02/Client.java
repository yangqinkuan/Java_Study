package Command.Demo02;

public class Client {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command commandOne = new ConcreteCommandOne(receiver);
		Command commandTwo = new ConcreteCommandTwo(receiver);
		Invoker invoker = new Invoker(commandOne, commandTwo);
		invoker.actionOne();
		invoker.actionTwo();
	}
}
