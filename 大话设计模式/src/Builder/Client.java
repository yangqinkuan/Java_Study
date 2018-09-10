package Builder;

public class Client {
	public static void main(String[] args) {
		BenzBuilder builder = new BenzBuilder();
		Producer director = new Producer(builder);
		director.Construct();
		Benz car = (Benz) builder.GetCar();
		System.out.println(car.body.getName());
		System.out.println(car.engine.getName());
	}
}
