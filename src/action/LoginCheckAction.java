package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.dao.MemberDAO;
import exam.dto.MemberDTO;

public class LoginCheckAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		boolean check = MemberDAO.instance().member_check(id, pw);
		
		if(check == true) {
			if(id.equals("admin")) {
				ArrayList<MemberDTO> list = MemberDAO.instance().getAllList();
				request.setAttribute("list", list);
				request.getRequestDispatcher("Controller?command=admin").forward(request, response);
			}
			else {
				ArrayList<MemberDTO> list = MemberDAO.instance().getAllList();
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getId().equals(id)) {
						request.setAttribute("id", list.get(i).getId());
						request.setAttribute("name", list.get(i).getName());
						request.setAttribute("point", list.get(i).getPoint());
						break;
					}
				}
				request.getRequestDispatcher("Controller?command=main").forward(request, response);
			}
		}
		else {
			response.sendRedirect("return_login.jsp");
		}
	}
}
