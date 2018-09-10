package Component;

public class Buygift {
	public static void main(String[] args) {
		GiftComposite gifts = new GiftComposite();
		gifts.add(new GiftComponent("手机"));
		gifts.add(new GiftComponent("电脑"));
		gifts.add(new GiftComponent("平板"));
		gifts.pay();
	}
}
