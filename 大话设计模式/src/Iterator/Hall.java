package Iterator;

public class Hall {
	Tree[] tree; //这里可以看作是聚合关系
	private int index; //指向Tree[] 的标签
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
