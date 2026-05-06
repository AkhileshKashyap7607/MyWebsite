package com.akhilesh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/per")
public class MyPersonalInfo extends HttpServlet {
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		Cookie c[]=request.getCookies();
		if(c!=null) {
			out.println("<img src= '/image/22222.jpg' height='200px' width='200px'>");
			out.println("<a href='logout'>LogOut</a>");
		}
		else {
			out.println("you are not authorized user,  Login First");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}
