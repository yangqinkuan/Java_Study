package serverdemo02;

public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request req,Response rep) throws Exception {
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(login(name,pwd)){
			rep.println("µÇÂ½³É¹¦");
		}else{
			rep.println("µÇÂ¼Ê§°Ü");
		}
	}
	public boolean login(String name,String pwd){
		return name.equals("bjsxt") && pwd.equals("123456");
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void doPost(Request req,Response rep) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
