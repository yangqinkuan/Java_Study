package flyweight.demo1;

public abstract class Order {
	//执行卖出动作
	public abstract void sell();
	//获取咖啡口味
	public abstract String getFlavor();
}
