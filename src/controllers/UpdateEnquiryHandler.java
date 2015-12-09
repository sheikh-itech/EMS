package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.UserService;
import dal.UserServiceImpl;
import dto.EnquiryDetail;

/**
 * Servlet implementation class UpdateEnquiryHandler
 */
@WebServlet("/updatehandler")
public class UpdateEnquiryHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");

			if (username != null && username != "") {
				
				String desc = request.getParameter("desc");
				int id = Integer.parseInt(request.getParameter("id"));
				
				UserService service = UserServiceImpl.getUserService();
				service.updateEnquiry(desc, id);
				List<EnquiryDetail> enqueryList = service.getEnquiryList(username);
				request.setAttribute("enqueryList", enqueryList);
				request.getRequestDispatcher("student").forward(request, response);

			}else response.sendRedirect("login");
		} catch (Exception ex) {
			response.sendRedirect("login");
			System.out.println(ex.getMessage());
		}

	}

}
