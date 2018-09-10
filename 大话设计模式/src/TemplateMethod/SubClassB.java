package TemplateMethod;

public class SubClassB extends ShowSubClassName{

	@Override
	public void showName() {
		System.out.println(this.getClass().getName());
	}
	
}
