package Bridge;

public abstract class Brush {
	protected Color c;
	public abstract void Paint();
	public void SetColor(Color c){
		this.c = c;
	}
}
