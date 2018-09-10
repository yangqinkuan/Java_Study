package Memento.Blackbox;

public class Originator {
	private String state;
	private NarrowMemento memento;
	
	public Originator() {
	}
	public NarrowMemento creteMemento(){
		memento = new Memento(this.state);
		return memento;
	}
	public void restoreMemento(NarrowMemento memento){
		Memento aMemento = (Memento) memento;
		this.setState(aMemento.getState());
		
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	//ÄÚ²¿Àà
	protected class Memento implements NarrowMemento{
		private String savedState;
		private Memento(String somestate){
			savedState = somestate;
		}
		
		private String getState() {
			return savedState;
		}

		private void setState(String savedState) {
			this.savedState = savedState;
		}

		@Override
		public void narrowMethod() {
			System.out.println(" this is narrow method");
		}
		public NarrowMemento getNarrowMemento(){
			return memento;
		}
		
	}
}
