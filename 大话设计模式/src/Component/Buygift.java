package Component;

public class Buygift {
	public static void main(String[] args) {
		GiftComposite gifts = new GiftComposite();
		gifts.add(new GiftComponent("�ֻ�"));
		gifts.add(new GiftComponent("����"));
		gifts.add(new GiftComponent("ƽ��"));
		gifts.pay();
	}
}
