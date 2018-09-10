package test;

import java.util.List;

import po.Emp;
import sorm.core.Query;
import sorm.core.QueryFactory;
import vo.EmpVO;
/**
 * 测试连接池的效率
 * @author Administrator
 *
 */
public class Test2 {
	
	public static void test01(){
		Query q = QueryFactory.createQuery();
		String sql2 = " select e.id,e.empname,salary+bonus 'xinshui',age,d.dname 'deptName',d.address 'deptAddr' from emp e "
				+"join dept d on e.deptId=d.id";
		List<EmpVO> list2 = q.queryRows(sql2, EmpVO.class,null);
		for (EmpVO e : list2) {
			System.out.println(e.getEmpname()+"--"+e.getDeptAddr()+"-"+e.getXinshui());
		}
	}
	
	public static void main(String[] args) {
//		Long a = System.currentTimeMillis();
//		for(int i=0;i<3000;i++){
//				test01();
//		}
//		long b = System.currentTimeMillis();
//		System.out.println((b-a));   //不加连接池的耗时:21957ms
		
		Emp e = new Emp();
		e.setId(42);;
		Query q = QueryFactory.createQuery();
		q.delete(e); 
	}
}
