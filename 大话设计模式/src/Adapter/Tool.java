package Adapter;

public class Tool {
	private String name;
	public Tool(String name){
		this.name = name;
	}
	public void use(int voltage){
		if(voltage==110){
			System.out.println("สนำร"+name);
		}
	}
	
}
