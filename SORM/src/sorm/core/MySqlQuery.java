package sorm.core;

import java.util.List;

import po.Emp;
import vo.EmpVO;
/**
 * 负责查询(对外提供服务的核心类)
 * @author yangqinkuan
 *
 */
public class MySqlQuery extends Query{
	public static void testDML(){
		Emp e = new Emp();
		e.setEmpname("lily");
		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
		e.setAge(30);
		e.setSalary(3000.8);
		e.setId(1);
		new MySqlQuery().update(e,new String[]{"empname","age","salary"});
//		new MySqlQuery().insert(e);
//		new MySqlQuery().delete(e);
	}
	
	public static void testQueryRows(){
		List<Emp> list = new MySqlQuery().queryRows("select id,empname,age from emp where age>? and salary<?", 
				Emp.class, new Object[]{10,5000});
				for (Emp e : list) {
					System.out.println(e.getEmpname());
				}
				String sql2 = " select e.id,e.empname,salary+bonus 'xinshui',age,d.dname 'deptName',d.address 'deptAddr' from emp e "
				+"join dept d on e.deptId=d.id";
				List<EmpVO> list2 = new MySqlQuery().queryRows(sql2, 
						EmpVO.class,null);
				for (EmpVO e : list2) {
					System.out.println(e.getEmpname()+"--"+e.getDeptAddr()+"-"+e.getXinshui());
				}
	}
	public static void main(String[] args) { 
//		Number obj = new MySqlQuery().queryNumber("select count(*) from emp where salary>?", new Object[]{1000});
		
//		testQueryRows();
		Number obj = (Number)new MySqlQuery().queryValue("select count(*) from emp where salary>?", new Object[]{1000});
		System.out.println((obj).doubleValue());
	}

	@Override
	public Object queryPagenate(int pageNum, int size) {
		return null;
	}

	
}
