package AbstractFactory;

public class ProductFactory2 implements AbstractFactory{

	@Override
	public AbstractProductA createA() {
		return new ProductA2();
	}

	@Override
	public AbstractProductB createB() {
		return new ProductB2();
	}
	
}
