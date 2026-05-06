package com.akhilesh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet2 extends HttpServlet {

  
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      
        String numberParam = req.getParameter("number");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        try {
            int number = Integer.parseInt(numberParam); 

            
            out.println("<html>");
            out.println("<head><title>Multiplication Table</title></head>");
            out.println("<body>");
            out.println("<h1>Multiplication Table for " + number + "</h1>");
            out.println("<table border='1' style='border-collapse: collapse; width: 50%; text-align: center;'>");
            out.println("<tr><th>Number</th><th>Multiplier</th><th>Product</th></tr>");

           
            for (int i = 1; i <= 10; i++) {
                out.println("<tr>");
                out.println("<td>" + number + "</td>");
                out.println("<td>" + i + "</td>");
                out.println("<td>" + (number * i) + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {
           
            out.println("<html><body><h2>Please provide a valid number in the 'number' parameter.</h2></body></html>");
        }
    }

    public void destroy() {
        
    }

    public jakarta.servlet.ServletConfig getServletConfig() {
        return null; 
    }

    public String getServletInfo() {
        return "Servlet for Multiplication Table";
    }
}
