package com.akhilesh.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String driverName="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://@localhost:3306/akhilesh";
		String username="root";
		String password="kashyap070703";
		String sql="insert into login values(?,?)";
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String userName=req.getParameter("userName");
		String userPassword=req.getParameter("userPassword");
		try {
			Class.forName(driverName);
			 Connection connection=DriverManager.getConnection(url,username,password);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, userPassword);
			Integer count=preparedStatement.executeUpdate();
			out.println("<h1>" + count + "Record added in a table</h1>");
		}
		catch(ClassNotFoundException e) {
			out.println(e);
		}
		catch(SQLException e) {
			out.println(e);
		}
}
}