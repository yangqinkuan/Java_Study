package Facade;

public class Customer {
	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.start();
		System.out.println("�������");
		computer.shutdown();
	}
}
