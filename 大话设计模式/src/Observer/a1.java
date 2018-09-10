package Observer;

public class a1 implements Observer{
	private String name;
	private int state;
	
	public a1(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public void update(int state) {
		this.state = state;
	}
	
}
