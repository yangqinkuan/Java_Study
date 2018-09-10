package Decorator.Demo01;

public class Mutton extends Decorator{
	
	public Mutton(Ingredient igd) {
		super(igd);
	}

	@Override
	public String getDescription() {
		String base = ingredient.getDescription();
		return base + " \n " + " Decorated with Mutton £¡ ";
	}

	@Override
	public double getCost() {
		double basePrice = ingredient.getCost();
		double muttonPrice = 2.3;
		return basePrice + muttonPrice;
	}
	
}
