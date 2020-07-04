package com.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Servlet")
public class MyFirstServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String fName = request.getParameter("fname");
        String lName = request.getParameter("lname");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String pwd = request.getParameter("password");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Register | Demo | Java Web App</title></head>");
        out.println("<body>");
        out.println("<h1>You had entered Below Details</h1>");
        out.println("<br /><br />");
        out.println("<h3><b>Name \t\t: <i>" + fName + " " + lName + "</i></b></h3>");
        out.println("<h3><b>Email \t\t: <i>" + email + "</i></b></h3>");
        out.println("<h3><b>Gender \t\t: <i>" + gender +"</i></b></h3>");
        out.println("<h3><b>Country \t\t: <i>" + country + "</i></b></h3>");
        out.println("<h3><b>Password \t\t: <i>" + pwd + "</i></b></h3>");
        out.println("</body></html>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn;

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_web_app_demo","root","");

            PreparedStatement ps = conn.prepareStatement("INSERT INTO employee (fname, lname, email, gender, country, password) VALUES (?,?,?,?,?,?)");

            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setString(5, country);
            ps.setString(6, pwd);

            boolean isInserted = ps.execute();

            if(!isInserted) {
                out.println("Successfully Inserted to Database");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }else {
                out.println("Not Inserted");
            }

            conn.commit();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
