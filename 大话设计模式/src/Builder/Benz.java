package Builder;

import java.util.ArrayList;

public class Benz extends Car{

	
	public Benz() {
	}
	public void AddBody(Body body){
		this.body = body;
	}
	public void AddEngine(Engine engine){
		this.engine = engine;
	}
	public void AddWheel(Wheel wheel){
		if(wheels==null){
			wheels = new ArrayList<Wheel>();
		}
		wheels.add(wheel);
	}
}
