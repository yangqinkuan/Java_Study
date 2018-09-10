package Command.Demo02;

public class Invoker {
	private Command commandOne;
	private Command commandTwo;
	public Invoker(Command commandOne, Command commandTwo) {
		this.commandOne = commandOne;
		this.commandTwo = commandTwo;
	}
	public void actionOne(){
		commandOne.execute();
	}
	public void actionTwo(){
		commandTwo.execute();
	}
}
