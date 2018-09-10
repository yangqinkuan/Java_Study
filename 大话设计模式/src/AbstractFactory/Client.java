package AbstractFactory;

public class Client {
	public static void main(String[] args) {
		ProductFactory1 productFactory1 = new ProductFactory1();
		ProductFactory2 productFactory2 = new ProductFactory2();
		AbstractProductA A1 = productFactory1.createA();
		AbstractProductA A2 = productFactory2.createA();
		AbstractProductB B1 = productFactory1.createB();
		AbstractProductB B2 = productFactory2.createB();
		A1.Sell();
		A2.Sell();
		B1.Sell();
		B2.Sell();
	}
}
