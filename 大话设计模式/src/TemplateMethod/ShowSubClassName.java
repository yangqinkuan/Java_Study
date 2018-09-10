package TemplateMethod;
/**
 * 父类定义好方法执行流程，子类各自实现自己的方法
 * @author Administrator
 *
 */
public abstract class ShowSubClassName {
	/**
	 * 这个方法的实现，我们交给子类完成
	 */
	public abstract void showName();
	public void show(){
		showName();
	}
}
