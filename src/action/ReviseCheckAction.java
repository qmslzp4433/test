package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.dao.MemberDAO;
import exam.dto.MemberDTO;

public class ReviseCheckAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ArrayList<MemberDTO> list = MemberDAO.instance().getAllList();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				request.setAttribute("id", list.get(i).getId());
				request.setAttribute("pw", list.get(i).getPw());				
				request.setAttribute("name", list.get(i).getName());
				request.setAttribute("point", list.get(i).getPoint());
				break;
			}
		}
		request.getRequestDispatcher("Controller?command=revise").forward(request, response);		
	}
}
