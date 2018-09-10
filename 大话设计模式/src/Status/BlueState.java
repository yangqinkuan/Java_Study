package Status;

public class BlueState extends State{

	@Override
	public void handlepush(Context c) {
		//根据push方法"如果是Blue状态的切换到Green"
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
