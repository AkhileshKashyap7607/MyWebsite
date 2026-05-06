package com.akhilesh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		Cookie c[]=request.getCookies();
		c[0].setMaxAge(0);
		c[1].setMaxAge(1);
		response.addCookie(c[0]);
		response.addCookie(c[1]);
		out.println("<h1>Logout Successful...</h1>");
		
	}

}
