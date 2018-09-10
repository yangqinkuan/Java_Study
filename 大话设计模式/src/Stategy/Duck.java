package Stategy;

public abstract class Duck {
	//为行为接口类型声明2个引用变量，所有的鸭子子类都继承它们
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	public Duck(){
		
	}
	//设定鸭子的行为，而不是在鸭子的构造器内实例化
	public void setFlyBehavior(FlyBehavior fb){
		flyBehavior = fb;
	}
	public void setQuackBehavior(QuackBehavior qb){
		quackBehavior = qb;
	}
	abstract void display();
	public void performFly(){
		flyBehavior.fly();
	}
	public void performQuack(){
		quackBehavior.quack();
	}
	public void swim(){
		System.out.println(" All ducks float,even decoys! ");
	}
}
