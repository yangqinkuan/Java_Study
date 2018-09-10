package Builder;

import java.util.ArrayList;

public abstract class Car {
	Body body;
	Engine engine;
	ArrayList<Wheel> wheels;
	public abstract void AddBody(Body body);
	public abstract void AddEngine(Engine engine);
	public abstract void AddWheel(Wheel wheel);
}
