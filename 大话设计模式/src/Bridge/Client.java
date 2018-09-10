package Bridge;

public class Client {
	public static void main(String[] args) {
		Brush bigbrush = new BigBrush();
		bigbrush.SetColor(new Red());
		bigbrush.Paint();
	}
}
