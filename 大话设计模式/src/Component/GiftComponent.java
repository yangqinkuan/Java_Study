package Component;

public class GiftComponent extends Gift{

	public GiftComponent(String name) {
		super(name);
	}

	@Override
	public void add(Gift c) {
		
	}

	@Override
	public void remove(Gift c) {
		
	}

	@Override
	public void pay() {
		System.out.println("ÎÒÂòÁË"+name);
	}
	
}
