package ResChain;

public class C extends Player{
	public C(Player aSuccessor){
		this.setSuccessor(aSuccessor);
	}
	@Override
	public void handle(int i) {
		if(i == 3){
			System.out.println(this.getClass().getSimpleName()+"������");
		}else{
			System.out.println(this.getClass().getSimpleName()+"������");
			System.out.println("û�㶨");
			
		}
	}

}
