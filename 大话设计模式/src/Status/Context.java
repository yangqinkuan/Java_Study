package Status;

public class Context {
	private State state = null;//���ǽ�ԭ����Color state �ĳ����½���State state;
	//setState �������ı�state ��״̬ ʹ��setStateʵ��״̬���л�
	public void setState(State state){
		this.state = state;
	}
	public void push(){
		//״̬���л���ϸ�ڲ��֣��ڱ���������ɫ�ı仯,�Ѿ���װ�������handlepush��ʵ��,�����������
		state.handlepush(this);
	}
	public void pull(){
		state.handlepull(this);
	}
}
