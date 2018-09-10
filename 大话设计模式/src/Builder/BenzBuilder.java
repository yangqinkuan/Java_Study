package Builder;

public class BenzBuilder extends CarBuilder{
	private Car car;
	
	@Override
	public void BuildBody() {
		car = new Benz();
		car.AddBody(new Body("business car body"));
	}

	@Override
	public void BuildEngine() {
		car.AddEngine(new Engine("Benz engine"));
	}

	@Override
	public void BuildWheel(String name) {
		car.AddWheel(new Wheel(name));
	}
	//��������,Benz����װ�����
	public Car GetCar(){
		return car;
	}

}
