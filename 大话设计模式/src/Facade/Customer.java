package Facade;

public class Customer {
	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.start();
		System.out.println("完成任务");
		computer.shutdown();
	}
}
