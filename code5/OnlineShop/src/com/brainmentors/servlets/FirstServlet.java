package com.brainmentors.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brainmentors.dao.UserDAO;
import com.brainmentors.dto.UserDTO;

/**
 * Servlet implementation class FirstServlet
 */
//@WebServlet("/login")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int visitCount;   
    
    @Override
    public void init(){
    		visitCount = 1;
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
    		doPost(req, response);
    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		String path = sc.getInitParameter("logger");
		String email = this.getServletConfig().getInitParameter("email");
		System.out.println("Email is "+email);
		System.out.println("Path is "+path);
		PrintWriter a = response.getWriter();
		String userid = req.getParameter("userid");
		String password = req.getParameter("pwd");
		String color = req.getParameter("color");
		boolean isFound = false;
		Cookie cookies [] = req.getCookies();
		System.out.println("Total Cookie Found "+cookies.length);
		if(cookies!=null && cookies.length>0){
    		for(Cookie c : cookies){
    			if(c.getName().equals("favcolor")){
    				isFound = true;
    				break;
    			}
    		}
    }	
		if(!isFound){
			System.out.println("Cookie Created "+color);
			Cookie cookie = new Cookie("favcolor",color);
			cookie.setMaxAge(365*24*60*60);
			response.addCookie(cookie);
		}
		
		UserDTO userDTO = new UserDTO(userid , password);
		UserDAO userDAO = new UserDAO();
		ServletContext s = this.getServletContext();
		String message=null;
		RequestDispatcher rd = req.getRequestDispatcher("Headers");
		rd.include(req, response);
		// Set standard HTTP/1.1 no-cache headers.
		//response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		//response.setHeader("Pragma", "no-cache");
		try {
			message = userDAO.login(userDTO);
			if(message.contains("Welcome")){
				HttpSession session = req.getSession(true);
				//session.setMaxInactiveInterval(1*60*1000);
				System.out.println("Session "+session.getId());
				session.setAttribute("uid", userid);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		response.sendRedirect("dashboard.jsp");
//		RequestDispatcher rd  = req.getRequestDispatcher("dashboard.jsp");
//		req.setAttribute("msg", message);
//		rd.forward(req, response);
		//response.sendRedirect("dashboard.jsp?msg="+message);
		//response.setContentType("text/html");
		//out.println("<h2>"+message+"</h2>");
		//out.println("Welcome User "+visitCount+" Userid "+userid+" Password "+password);
		//visitCount++;
		a.close();
	}

}
