package Status;

public class Context {
	private State state = null;//我们将原来的Color state 改成了新建的State state;
	//setState 是用来改变state 的状态 使用setState实现状态的切换
	public void setState(State state){
		this.state = state;
	}
	public void push(){
		//状态的切换的细节部分，在本例中是颜色的变化,已经封装在子类的handlepush中实现,这里无需关心
		state.handlepush(this);
	}
	public void pull(){
		state.handlepull(this);
	}
}
