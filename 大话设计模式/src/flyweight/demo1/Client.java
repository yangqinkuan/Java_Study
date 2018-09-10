package flyweight.demo1;

import java.util.ArrayList;
import java.util.List;

public class Client {
	//�ͻ��µĶ���
	private static List<Order> orders = new ArrayList<Order>(100);
	//�����������ɹ���
	private static FlavorFactory flavorFactory;
	//���Ӷ���
	private static void takeOrders(String flavor){
		orders.add(flavorFactory.getOrder(flavor));
	}
	public static void main(String[] args) {
		//��ȡflavorFactoryʵ��
		flavorFactory = FlavorFactory.getInstance();
		takeOrders("Ħ��");
		takeOrders("������ŵ");
		takeOrders("����Ǳ���");
		takeOrders("����Ǳ���");
		takeOrders("����");
		takeOrders("������ŵ");
		takeOrders("����");
		takeOrders("Ħ��");
		//������
		for(Order order:orders){
			order.sell();
		}
		//��ӡ���ɵĶ���java��������
		System.out.println(" \n �ͻ�һ������"+orders.size()+"������!");
		//��ӡ���ɵĶ���java��������
		System.out.println(" \n �������� " + flavorFactory.getTotalFlavorsMade()+"��FlavorOrder java����!");
		
	}
}
