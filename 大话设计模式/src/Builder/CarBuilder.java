package Builder;

public abstract class CarBuilder {
	public abstract void BuildBody();//生产车身
	public abstract void BuildEngine();//生产引擎
	public abstract void BuildWheel(String name);//生成车轮
}
