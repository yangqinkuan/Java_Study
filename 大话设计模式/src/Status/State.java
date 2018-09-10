package Status;

public abstract class State {
	public abstract void handlepush(Context c);
	public abstract void handlepull(Context c);
	public abstract void getColor();
}
