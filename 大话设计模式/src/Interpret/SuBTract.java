package Interpret;

public class SuBTract extends Expression{
	private Expression left, right;
	public SuBTract(Expression left,Expression right){
		this.left = left;
		this.right = right;
	}
	@Override
	public int interpret(Context con) {
		return left.interpret(con) - right.interpret(con);
	}

}
