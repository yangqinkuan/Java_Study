package Decorator.Demo01;

public class Celery extends Decorator{
	
	public Celery(Ingredient igd) {
		super(igd);
	}

	@Override
	public String getDescription() {
		String base = ingredient.getDescription();
		return base + " \n " + " Decrocated with Celey! ";
	}

	@Override
	public double getCost() {
		double basePrice = ingredient.getCost();
		double celeryPrice = 0.6;
		return basePrice + celeryPrice;
	}
	
}
