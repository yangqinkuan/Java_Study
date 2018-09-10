package flyweight.demo1;

import java.util.HashMap;
import java.util.Map;

public class FlavorFactory {
	//������
	private Map<String, Order> flaverPool = new HashMap<String, Order>(20);
	//��̬����,�������ɶ�������
	private static FlavorFactory flavorFactory = new FlavorFactory();
	private FlavorFactory(){}
	public static FlavorFactory getInstance(){
		return flavorFactory;
	}
	//��ȡ����
	public Order getOrder(String flavor){
		Order order = null;
		if(flaverPool.containsKey(flavor)){
			order = flaverPool.get(flavor);
		}else{
			order = new FlavorOrder(flavor);
			flaverPool.put(flavor, order);
			
		}
		return order;
	}
	//����Ѿ������Ŀ���ȫ����ζ����
	public int getTotalFlavorsMade(){
		return flaverPool.size();
	}
}
