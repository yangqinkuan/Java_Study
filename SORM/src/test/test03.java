package test;

import po.Dept;
import sorm.core.Query;
import sorm.core.QueryFactory;
import sorm.core.TableContext;

public class test03 {
	public static void main(String[] args) {
		
			
//			//ͨ�����������������po�࣡
//			TableContext.updateJavaPOFile();
			
			Dept e = new Dept();
			e.setAddress("asdasd");
			Query q = QueryFactory.createQuery();
			q.insert(e); 
			
		}
}
