package ResChain;

public class B extends Player{
	public B(Player aSuccessor){
		this.setSuccessor(aSuccessor);
	}
	@Override
	public void handle(int i) {
		if(i == 2){
			System.out.println(this.getClass().getSimpleName()+"������");
		}else{
			System.out.println(this.getClass().getSimpleName()+"������");
			next(i);
		}
	}

}
