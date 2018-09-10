package Interpret;

public class Division extends Expression{
	private Expression left,right;
	
	public Division(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpret(Context con) {
		try {
			return left.interpret(con) / right.interpret(con);
		} catch (ArithmeticException e) {
			System.out.println(" ������Ϊ0! ");
			return -11111;
		}
	}

}
