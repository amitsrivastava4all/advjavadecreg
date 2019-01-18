package com.brainmentors.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		UserDTO userDTO = new UserDTO(userid , password);
		UserDAO userDAO = new UserDAO();
		String message=null;
		try {
			message = userDAO.login(userDTO);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		response.setContentType("text/html");
		out.println("<h2>"+message+"</h2>");
		//out.println("Welcome User "+visitCount+" Userid "+userid+" Password "+password);
		//visitCount++;
		out.close();
	}

}
