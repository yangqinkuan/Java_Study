package TemplateMethod;

public class Test {
	public static void main(String[] args) {
		ShowSubClassName classA = new SubClassA();
		classA.show();
		ShowSubClassName classB = new SubClassB();
		classB.show();
	}
}
