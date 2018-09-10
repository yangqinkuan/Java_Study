package Component;

public abstract class Gift {
	String name;
	public Gift(){
		
	}
	public Gift(String name){
		this.name = name;
	}
	public abstract void add(Gift c);
	public abstract void remove(Gift c);
	public abstract void pay();
}
