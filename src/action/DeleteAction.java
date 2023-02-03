package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import exam.dao.MemberDAO;

public class DeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		int check = MemberDAO.instance().member_delete(id);
		
		PrintWriter out = response.getWriter();
		
		JSONObject obj = new JSONObject();
		
		response.setContentType("application/json");
		
		if(check == 1) {
			obj.put("check", "true");
		}
		else {			
			obj.put("check", "false");
		}
		
		out.println(obj);
		
	}
}
