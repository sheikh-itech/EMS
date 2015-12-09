package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.UserService;
import dal.UserServiceImpl;
import dto.Users;

/**
 * Servlet implementation class Register
 */
@WebServlet("/registeruser")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			
			String username = request.getParameter("username");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String usertype = request.getParameter("usertype");
			long contact = Integer.parseInt(request.getParameter("contact"));
			
			Users users = new Users();
			users.setUsername(username);
			users.setName(name);
			users.setPassword(password);
			users.setType(usertype);
			users.setContact(contact);
			//users.setEnquiry_handled(0);		
			
			UserService service = UserServiceImpl.getUserService();
			service.saveUserDetails(users);
			response.sendRedirect("login");
			
			
		}catch(Exception ex){
			request.setAttribute("flag", true);
			request.getRequestDispatcher("register").forward(request, response);
			
		}
	}

}
