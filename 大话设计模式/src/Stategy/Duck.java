package Stategy;

public abstract class Duck {
	//Ϊ��Ϊ�ӿ���������2�����ñ��������е�Ѽ�����඼�̳�����
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	public Duck(){
		
	}
	//�趨Ѽ�ӵ���Ϊ����������Ѽ�ӵĹ�������ʵ����
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
