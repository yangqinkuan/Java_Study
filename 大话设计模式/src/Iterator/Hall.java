package Iterator;

public class Hall {
	Tree[] tree; //������Կ����ǾۺϹ�ϵ
	private int index; //ָ��Tree[] �ı�ǩ
	public Hall(int maxNumber){
		tree = new Tree[maxNumber];
		index = 0;
	}
	public void add(Tree tree){
		this.tree[index] = tree;
		index++;
	}
	public Iterator connectIterator(){
		return new TreeIterator(this);
	}
}
