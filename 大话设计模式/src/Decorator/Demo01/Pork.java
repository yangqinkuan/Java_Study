package Decorator.Demo01;

public class Pork extends Decorator{
	
	public Pork(Ingredient igd) {
		super(igd);
	}

	@Override
	public String getDescription() {
		String base = ingredient.getDescription();
		return base + " \n " + "Decorated with Pork!";
	}

	@Override
	public double getCost() {
		double basePrice = ingredient.getCost();
		double porkPrice = 1.8;
		return basePrice + porkPrice;
	}

}
