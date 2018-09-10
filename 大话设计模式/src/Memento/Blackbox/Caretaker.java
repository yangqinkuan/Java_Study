package Memento.Blackbox;

public class Caretaker {
	private NarrowMemento memento;
	public NarrowMemento retrieveMemento(){
		return this.memento;
	}
	public void saveMemento(NarrowMemento memento){
		this.memento = memento;
	}
}
