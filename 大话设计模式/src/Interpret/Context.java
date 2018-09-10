package Interpret;

import java.util.HashMap;
import java.util.Map;

public class Context {
	private Map<Variable, Integer> valueMap = new HashMap<Variable, Integer>();
	
	public void addValue(Variable x,int y){
		Integer yi = new Integer(y);
		valueMap.put(x, yi);
	}
	public int LookupValue(Variable x){
		int i = ((Integer)valueMap.get(x)).intValue();
		return i;
	}
}
