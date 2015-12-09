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
import dto.EnquiryDetail;

/**
 * Servlet implementation class TodaysEnquiryHandler
 */
@WebServlet("/todaysEnquiry")
public class TodaysEnquiryHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StaffService staff = StaffServiceImpl.getService();
		List<EnquiryDetail> enqueryList = null;
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if (username != null && username != "") {
			
			enqueryList = staff.getTodaysEnquiryList();
			request.setAttribute("enqueryList", enqueryList);
			request.setAttribute("enquiries", staff.handledEnquiries(username));
			request.getRequestDispatcher("staff").forward(request, response);
			
		} else
			request.getRequestDispatcher("login").forward(request, response);

	}

}
