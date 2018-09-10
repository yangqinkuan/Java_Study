package Decorator.Demo01;

public class DecoratorTest {
	public static void main(String[] args) {
		Ingredient compound = new Mutton(new Celery(new Bread("Master24's Bread")));
		compound.printDescription();
	}
}
