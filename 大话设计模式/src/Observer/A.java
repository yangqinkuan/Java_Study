package Observer;

public class A extends Subject{
	private int state;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public A(int state) {
		this.state = state;
	}

	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers(int state) {
		for (Observer observer : observers) {
			observer.update(state);
		}
	}
	
	public void change(int newstate){
		state = newstate;
	}
	
}
