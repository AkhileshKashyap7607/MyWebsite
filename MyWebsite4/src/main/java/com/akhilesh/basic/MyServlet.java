package com.akhilesh.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
   

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/akhilesh";
        String username = "root";
        String password = "kashyap070703";
        String sql = "SELECT * FROM emp WHERE eno=?";
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Retrieve the employee number from the request
            int eno = Integer.parseInt(req.getParameter("eno"));

            // Load the JDBC driver
            Class.forName(driverName);

            // Establish the connection
            conn = DriverManager.getConnection(url, username, password);

            // Prepare the SQL statement
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eno);

            // Execute the query
            rs = pstmt.executeQuery();

            // Display the result
            out.println("<html><body>");
            if (rs.next()) {
                out.println("<h1>Employee Details</h1>");
                out.println("<p>Employee Number: " + rs.getInt("eno") + "</p>");
                out.println("<p>Name: " + rs.getString("ename") + "</p>");
               
                out.println("<p>Salary: " + rs.getDouble("esal") + "</p>");
            } else {
                out.println("<h1>No Employee Found with ENO: " + eno + "</h1>");
            }
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace(out); // Print the stack trace for debugging
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace(out);
            }
        }
    }
}
