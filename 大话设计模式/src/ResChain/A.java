package ResChain;

public class A extends Player{
	public A(Player aSuccessor){
		this.setSuccessor(aSuccessor);
	}
	@Override
	public void handle(int i) {
		if(i == 1){
			System.out.println(this.getClass().getSimpleName()+"������");
		}else{
			System.out.println(this.getClass().getSimpleName()+"������");
			next(i);
		}
	}

}
