package Iterator;

public class Pren {
	public Pren(){}
	public static void main(String[] args) {
		Hall hall = new Hall(5);
		hall.add(new Tree("Æ»¹ûÊ÷"));
		hall.add(new Tree("ÀæÊ÷"));
		hall.add(new Tree("éÙ×ÓÊ÷"));
		hall.add(new Tree("·ïÀæÊ÷"));
		hall.add(new Tree("²İ"));
		for(Iterator i = hall.connectIterator();i.hasNext();){
			String Type = ((Tree)(i.next())).getName();
			switch (Type) {
			case "Æ»¹ûÊ÷":
				System.out.println(" È÷Æ»¹ûÊ÷µÄÅ©Ò©");
				break;
			case "ÀæÊ÷":
				System.out.println(" È÷Æ»ÀæÊ÷µÄÅ©Ò©");
				break;
			case "éÙ×ÓÊ÷":
				System.out.println(" È÷Æ»éÙ×ÓÊ÷µÄÅ©Ò©");
				break;
			case "·ïÀæÊ÷":
				System.out.println(" È÷Æ»·ïÀæÊ÷µÄÅ©Ò©");
				break;
			default:
				System.out.println("²»Åç");
				break;
			}
		}
	}
}
