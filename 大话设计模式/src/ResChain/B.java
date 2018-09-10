package ResChain;

public class B extends Player{
	public B(Player aSuccessor){
		this.setSuccessor(aSuccessor);
	}
	@Override
	public void handle(int i) {
		if(i == 2){
			System.out.println(this.getClass().getSimpleName()+"处理了");
		}else{
			System.out.println(this.getClass().getSimpleName()+"跳过了");
			next(i);
		}
	}

}
