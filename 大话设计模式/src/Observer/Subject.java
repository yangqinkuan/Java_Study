package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	List<Observer> observers = new ArrayList<Observer>();
	public abstract void attach(Observer o);
	public abstract void detach(Observer o);
	public abstract void notifyObservers(int state);

	
}
