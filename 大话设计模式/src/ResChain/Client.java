package ResChain;

public class Client {
	private static Player player;
	public static void main(String[] args) {
		player = new A(new B(new C(null)));
		player.handle(4);
	}
}
