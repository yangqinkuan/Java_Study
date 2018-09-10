package Status;

public class GreenState extends State{
	
	@Override
	public void handlepush(Context c) {
		c.setState(new BlueState());
	}

	@Override
	public void handlepull(Context c) {
		c.setState(new BlueState());
	}

	@Override
	public void getColor() {
		// TODO Auto-generated method stub
		
	}

}
