package Decorator.Demo02;

public class ConcreteDecorator extends Decorator{

	public ConcreteDecorator(Component component) {
		super(component);
	}
	private void addedBehavior(){
		//some extra functionality goes here
	}
	public void doSomething(){
		component.doSomething();
		addedBehavior();
	}
}
