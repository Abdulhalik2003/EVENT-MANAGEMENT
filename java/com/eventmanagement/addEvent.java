package com.eventmanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.*;
import jakarta.servlet.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class addEvent extends HttpServlet 
{

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       String a1 = request.getParameter("eventno");
       String a2 = request.getParameter("eventname");
       String a3 = request.getParameter("coordinatorname");
       String a4 = request.getParameter("coordinatornumber");
       String a5 = request.getParameter("fee");
       String a6 = request.getParameter("venue");
       String a7 = request.getParameter("date");
       
      
           try
           { 
                Class.forName("com.mysql.cj.jdbc.Driver");
                String conURL = "jdbc:mysql://localhost:3306/EVENTMANAGEMENT";
                String userName = "root";
                String userPassword = "root";
                Connection con = DriverManager.getConnection(conURL, userName, userPassword);
                con.setAutoCommit(false); 

                Statement statement = con.createStatement();
                String queryStatement = "insert into event_ values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"')";
                statement.executeUpdate(queryStatement);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("CreateE.html");
                requestDispatcher.include(request, response);

                out.println("<br><center><h3> Event Added</h3></center>");

                response.setContentType("text/html");  
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Success! ... Event Details Added To Database!');");  
                out.println("</script>");
                con.commit();
                con.close();
            
        	   }
        	   catch(ServletException | IOException | ClassNotFoundException | SQLException e){
                System.out.println("Exception caught: " + e);
            }
           
       }
       
    }


