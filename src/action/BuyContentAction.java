package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import exam.dao.MemberDAO;

public class BuyContentAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		int point = Integer.parseInt(request.getParameter("point"));
		
		JSONObject obj = new JSONObject();
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("application/json");
		
		if(content.equals("intro")) {
			if(point < 100000) {
				obj.put("check", "false");
			}
			else {
				obj.put("check", "true");
				int check = MemberDAO.instance().point_sub(100000, id);
				if(check == 1) {
					point = MemberDAO.instance().getPoint(id);
				}
				else {
					System.out.println("에러");
				}
			}
		}
		else if(content.equals("java")) {
			if(point < 500000) {
				obj.put("check", "false");
			}
			else {
				obj.put("check", "true");
				int check = MemberDAO.instance().point_sub(500000, id);
				if(check == 1) {
					point = MemberDAO.instance().getPoint(id);
				}
				else {
					System.out.println("에러");
				}
			}
		}
		else if(content.equals("cpp")) {
			if(point < 300000) {
				obj.put("check", "false");
			}
			else {
				obj.put("check", "true");
				int check = MemberDAO.instance().point_sub(300000, id);
				if(check == 1) {
					point = MemberDAO.instance().getPoint(id);
				}
				else {
					System.out.println("에러");
				}
			}
		}
		
		obj.put("point", point);
		
		out.println(obj);
	
	}
}
