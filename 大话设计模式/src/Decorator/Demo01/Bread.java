package Decorator.Demo01;

public class Bread extends Ingredient{
	private String decription;
	
	public Bread(String desc) {
		this.decription = desc;
	}

	@Override
	public String getDescription() {
		return decription;
	}

	@Override
	public double getCost() {
		return 2.48;
	}

}
