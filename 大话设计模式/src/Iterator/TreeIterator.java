package Iterator;

public class TreeIterator implements Iterator {
	private int last = 0;
	private Hall hall;
	
	public TreeIterator(Hall hall){
		this.hall = hall;
	}
	@Override
	public boolean hasNext() {
		if(last<hall.tree.length){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Object next() {
		Tree t = hall.tree[last];
		last++;
		return t;
	}

}
