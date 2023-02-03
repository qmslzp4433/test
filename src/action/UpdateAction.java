package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.dao.MemberDAO;
import exam.dto.MemberDTO;

public class UpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		MemberDAO.instance().member_revise(pw, name, point, id);
		
		ArrayList<MemberDTO> list = MemberDAO.instance().getAllList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("Controller?command=admin").forward(request, response);	
	}
}
