package Stategy;

public class MuteQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println(" <<Slience>> ");
	}

}
