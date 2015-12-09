package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.StaffService;
import dal.StaffServiceImpl;
import dal.UserService;
import dal.UserServiceImpl;
import dto.EnquiryDetail;
import dto.Users;

/**
 * Servlet implementation class UserAuthentication
 */
@WebServlet("/authenticate")
public class UserAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			String username = request.getParameter("username");

			String password = request.getParameter("password");

			UserService service = UserServiceImpl.getUserService();
			StaffService staff = StaffServiceImpl.getService();

			String usertype = service.validateUser(username, password);
			List<EnquiryDetail> enqueryList = null;
			if (usertype != null) {

				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				if (usertype.equalsIgnoreCase("student")) {

					response.sendRedirect("student");
					return;
				} else if (usertype.equalsIgnoreCase("staff")) {

					enqueryList = staff.getEnquiryList();
					request.setAttribute("enqueryList", enqueryList);
					request.setAttribute("enquiries", staff.handledEnquiries(username));
					request.getRequestDispatcher("staff").forward(request, response);
					// response.sendRedirect("staff");
					return;
				}

			} else {
				request.setAttribute("flag", true);
				request.getRequestDispatcher("login").forward(request, response);
				return;

			}

		} catch (Exception ex) {
			request.setAttribute("flag", true);
			request.getRequestDispatcher("login").forward(request, response);
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try
		{
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login");//request.getRequestDispatcher("login").forward(request, response);
			return;
			
		}catch(Exception e){
			response.sendRedirect("login");//request.getRequestDispatcher("login").forward(request, response);
			return;
		}
	}

}
