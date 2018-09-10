package TemplateMethod;

public class SubClassA extends ShowSubClassName{

	@Override
	public void showName() {
		System.out.println(this.getClass().getName());
	}
	
}
