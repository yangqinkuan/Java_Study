package Status;

public class BlueState extends State{

	@Override
	public void handlepush(Context c) {
		//����push����"�����Blue״̬���л���Green"
		c.setState(new GreenState());
	}

	@Override
	public void handlepull(Context c) {
		c.setState(new GreenState());
	}

	@Override
	public void getColor() {
	}

}
