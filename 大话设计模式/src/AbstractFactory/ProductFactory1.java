package AbstractFactory;

public class ProductFactory1 implements AbstractFactory{

	@Override
	public AbstractProductA createA() {
		return new ProductA1();
	}

	@Override
	public AbstractProductB createB() {
		return new ProductB1();
	}
	
}
