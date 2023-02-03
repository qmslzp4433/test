package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import exam.dao.MemberDAO;

public class AdPointAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ad_point = Integer.parseInt(request.getParameter("point"));
		String id = request.getParameter("id");
		
		int check = MemberDAO.instance().point_add(ad_point, id);
		
		int point = 0;
		
		if(check == 1) {
			point = MemberDAO.instance().getPoint(id);
		}
		else {
			System.out.println("에러");
		}
		
		JSONObject obj = new JSONObject();
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("application/json");
		
		obj.put("point", point);
		
		out.println(obj);
		
	}
}
