package Builder;

public class Producer {
	private CarBuilder builder;

	public Producer(CarBuilder builder) {
		this.builder = builder;
	}
	public void Construct(){
		builder.BuildBody();
		builder.BuildEngine();
		builder.BuildWheel("front left");
		builder.BuildWheel("front right");
		builder.BuildWheel("back left");
		builder.BuildWheel("back left");
	}
}
