package ResChain;

public class C extends Player{
	public C(Player aSuccessor){
		this.setSuccessor(aSuccessor);
	}
	@Override
	public void handle(int i) {
		if(i == 3){
			System.out.println(this.getClass().getSimpleName()+"处理了");
		}else{
			System.out.println(this.getClass().getSimpleName()+"跳过了");
			System.out.println("没搞定");
			
		}
	}

}
