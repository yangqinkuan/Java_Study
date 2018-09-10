package flyweight.demo1;

import java.util.HashMap;
import java.util.Map;

public class FlavorFactory {
	//订单池
	private Map<String, Order> flaverPool = new HashMap<String, Order>(20);
	//静态工厂,负责生成订单对象
	private static FlavorFactory flavorFactory = new FlavorFactory();
	private FlavorFactory(){}
	public static FlavorFactory getInstance(){
		return flavorFactory;
	}
	//获取订单
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
	//获得已经卖出的咖啡全部口味数量
	public int getTotalFlavorsMade(){
		return flaverPool.size();
	}
}
