package com.eventmanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class viewEvent extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Event Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/EVENTMANAGEMENT";
            String dbusername = "root";
            String dbuserpassword = "root";
            Connection con;
            con = DriverManager.getConnection(conURL , dbusername, dbuserpassword);
            con.setAutoCommit(false);
            response.setContentType("text/html");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from event_");
            out.println("<h1 style=\"text-align: center\">Welcome  ... An Event Management Portal!</h1>");
            out.println("<center><h1>Event Details</h1></center>");
            out.println("<div>");
            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th> Event Number </th><th> Event Name</th><th>Coordinator</th><th> Coordinator Contact</th><th>Fees</th><th>Venue</th><th>Date</th>");  
            //request.getParameter
            while(resultSet.next()){
                String eventnumber = resultSet.getString("eventno");
                String  eventname= resultSet.getString("eventname");
                String coordinatorname = resultSet.getString("coordinatorname");
                String coordinatornumber = resultSet.getString("coordinatornumber");
                String fee = resultSet.getString("fee");
                String venue = resultSet.getString("venue");
                String date = resultSet.getString("date");
                out.println("<tr><td>" + eventnumber + "</td><td>" + eventname +"</td><td>"+coordinatorname+"</td><td>"+coordinatornumber+"</td><td>"+fee+"</td><td>"+venue+"</td><td>"+date+"</td></tr>");   
                
            }
            
            con.commit();
            con.close();
            out.println("</table>"); 
            out.println("<br>");
            out.println("</div>");
            out.println("</center>");
            out.println("<div>");
            out.println("<label class=\"topnav-right\"> © 1999-2022 Evently. All rights reserved. </label>");
            out.println("</div>");
            out.print("</body>");
            out.print("</html>");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Exception Caught: " + e);
        }
    }

}
