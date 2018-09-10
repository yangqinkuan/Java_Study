package Component;

import java.util.ArrayList;
import java.util.List;

public class GiftComposite extends Gift{
	private String name;
    public GiftComposite() {
		this.name = "��������";
	}

	private List<Gift> gifts = new ArrayList<Gift>();
	

	@Override
	public void add(Gift c) {
		gifts.add(c);
	}

	@Override
	public void remove(Gift c) {
		gifts.remove(c);
	}

	@Override
	public void pay() {
		for (Gift gift : gifts) {
			System.out.println("������"+name+gift.name);
		}
	}
	
}
