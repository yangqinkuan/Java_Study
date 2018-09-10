package Interpret;

public class Variable extends Expression{

	@Override
	public int interpret(Context con) {
		return con.LookupValue(this);
	}

}
