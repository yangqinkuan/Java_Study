package Observer;

public class Client {
	public static void main(String[] args) {
		A a = new A(0);
		a1 a1 = new a1("1�Ź���");
		a1 a2 = new a1("2�Ź���");
		a1 a3 = new a1("3�Ź���");
		a.attach(a1);
		a.attach(a2);
		a.attach(a3);
		a.change(1);
		System.out.println(a.getState());
		a.notifyObservers(a.getState());
		
		System.out.println(a1.getName()+a1.getState());
		System.out.println(a2.getName()+a2.getState());
		System.out.println(a3.getName()+a3.getState());
	}
}
