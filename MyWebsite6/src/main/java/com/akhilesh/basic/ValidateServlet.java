package com.akhilesh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vali")
public class ValidateServlet extends HttpServlet {
	
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<h1>Inbox</h1><hr>");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		if(userName.equals("admin") && userPassword.equals("pass")) {
			out.println("<h1>Main Page</h1><hr>");
			Cookie c1 = new Cookie("uname", userName);
			Cookie c2 = new Cookie("upass", userPassword);
			c1.setMaxAge(60);
			c2.setMaxAge(60);
			response.addCookie(c1);
			response.addCookie(c2);
			out.println("<a href ='per'>Next</a>");
		}
	}

}
