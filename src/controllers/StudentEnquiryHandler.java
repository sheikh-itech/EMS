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
import dto.Enquiry;
import dto.EnquiryDetail;

/**
 * Servlet implementation class EnquiryHandlerController
 */
@WebServlet("/enquiryhandler")
public class StudentEnquiryHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String enquiry = request.getParameter("desc");

			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");

			if (username != null && username != "") {
				Enquiry enq = new Enquiry();
				
				enq.setDescription(enquiry);
				enq.setUsername(username);
				
				UserService service = UserServiceImpl.getUserService();
				enq.setId(service.getMaxId()+1);
				service.saveEnquiry(enq);
				List<EnquiryDetail> enqueryList = service.getEnquiryList(username);
				request.setAttribute("enqueryList", enqueryList);
				request.getRequestDispatcher("student").forward(request, response);
				//response.sendRedirect("student");

			}else response.sendRedirect("login");
		} catch (Exception ex) {
			response.sendRedirect("login");
			System.out.println(ex.getMessage());
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");

			if (username != null && username != "") {
				
				String desc = request.getParameter("desc");
				int id = Integer.parseInt(request.getParameter("id"));
				UserService service = UserServiceImpl.getUserService();
				EnquiryDetail enquiryDetail = service.getEnquiryDetail(id);
				request.setAttribute("enquiryDetail", enquiryDetail);
				request.getRequestDispatcher("update").forward(request, response);
				//response.sendRedirect("student");

			}else response.sendRedirect("login");
		} catch (Exception ex) {
			response.sendRedirect("login");
			System.out.println(ex.getMessage());
		}
	}

}
