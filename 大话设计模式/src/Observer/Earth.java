package Observer;

import java.util.Observable;

public class Earth extends Observable{
	private String weather = "«Á¿ ";

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	@Override
	protected synchronized void setChanged() {
		super.setChanged();
	}
	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		super.notifyObservers(arg);
	}
}
