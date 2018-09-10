package Decorator.Demo01;

public class GreenGrocery extends Decorator{

	public GreenGrocery(Ingredient igd) {
		super(igd);
	}

	@Override
	public String getDescription() {
		String base = ingredient.getDescription();
		return base + " \n" + " Decrocated with GreenGrocery ! ";
	}

	@Override
	public double getCost() {
		double basePrice = ingredient.getCost();
		double greenGroceryPrice = 0.4;
		return basePrice + greenGroceryPrice;
	}

}
