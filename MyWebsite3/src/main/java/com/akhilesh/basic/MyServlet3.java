package com.akhilesh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet3 extends HttpServlet{
 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 res.setContentType("text/html");
	 PrintWriter out = res.getWriter();
	 Integer num = Integer.parseInt(req.getParameter("num"));
	 out.println("<h1 style ='text-align:center;'>Multiplication Table for " + num + "</h1>");
	 out.println("<table border='1' width='15%' margin='auto' text-align='center'>");
	 for(int i=1;i<=10;i++) {
		 out.println("<tr>");
		 out.println("<td>" + num + "</td>");
		 out.println("<td>*</td>");
		 out.println("<td>" + i + "</td>");
		 out.println("<td>=</td>");
		 out.println("<td>" + num*i + "</td>");
		 out.println("<tr>");
	 }
	 out.println("</table>");
	 out.println("<a href='PrintTable.html'>Go Back</a>");
	 }
}
