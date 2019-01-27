package com.brainmentors.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout.do")
public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Headers");
		rd.include(request, response);
		HttpSession session = request.getSession(false);
		
//		if(session == null || session.getAttribute("uid")==null){
//			response.sendRedirect("index.html");
//			
//		}
//		else{
			session.invalidate();
			response.sendRedirect("logout.html");
		//}
	}

}
