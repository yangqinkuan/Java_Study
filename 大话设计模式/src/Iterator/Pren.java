package Iterator;

public class Pren {
	public Pren(){}
	public static void main(String[] args) {
		Hall hall = new Hall(5);
		hall.add(new Tree("ƻ����"));
		hall.add(new Tree("����"));
		hall.add(new Tree("������"));
		hall.add(new Tree("������"));
		hall.add(new Tree("��"));
		for(Iterator i = hall.connectIterator();i.hasNext();){
			String Type = ((Tree)(i.next())).getName();
			switch (Type) {
			case "ƻ����":
				System.out.println(" ��ƻ������ũҩ");
				break;
			case "����":
				System.out.println(" ��ƻ������ũҩ");
				break;
			case "������":
				System.out.println(" ��ƻ��������ũҩ");
				break;
			case "������":
				System.out.println(" ��ƻ��������ũҩ");
				break;
			default:
				System.out.println("����");
				break;
			}
		}
	}
}
