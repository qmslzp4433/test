package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import exam.dao.MemberDAO;

public class IdCheckAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		boolean check = MemberDAO.instance().id_check(id);
		
		JSONObject obj = new JSONObject();
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("application/json");
		
		obj.put("check", check);
				
		out.println(obj);
		
	}
}
