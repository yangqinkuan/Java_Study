package servlet;

import server.Request;
import server.Response;

public class LoginWeb extends Servlet{

	@Override
	public void doGet(Request req, Response rep) throws Exception {
		// TODO Auto-generated method stub
		rep.println("你是一个大傻瓜");
		}

	@Override
	public void doPost(Request req, Response rep) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
