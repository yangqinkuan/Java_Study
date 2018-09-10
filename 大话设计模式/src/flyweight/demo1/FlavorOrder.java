package flyweight.demo1;

public class FlavorOrder extends Order{
	private String flavor;
	
	public FlavorOrder(String flavor) {
		this.flavor = flavor;
	}

	@Override
	public void sell() {
		System.out.println(" ����һ��["+ flavor +"].");
	}

	@Override
	public String getFlavor() {
		return this.flavor;
	}
	
}
