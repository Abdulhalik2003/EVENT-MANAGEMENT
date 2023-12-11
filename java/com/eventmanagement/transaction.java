package com.eventmanagement;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class transaction extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<h1 style=\"text-align: center\">Welcome To Evently ... An Event Management Portal!</h1>");
        out.println("<title> Transactions Page</title>");
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
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from card");
            
            out.println("<center><h1> Transaction  Details </h1> </center> ");
            out.println("<div>");
            out.println("<left><p><a href=\"transactiondetails.html\"><button> Event Details Page </button> </a></p></left>");
            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Event No</th><th>Event Name</th><th>Name</th><th>Payment Date</th>"); 
            
            while(resultSet.next()){
                
                String en = resultSet.getString("eventnumber");
                String re = resultSet.getString("eventname");
                String pd = resultSet.getString("eventdate");
                String name = resultSet.getString("cardusername");
               
                out.println("<tr><td>" + en + "</td><td>" + re + "</td><td>"+name+"</td><td>" + pd +"</td></tr>"); 
             
            }
            
            con.commit();
            con.close(); 
            out.println("</table>"); 
            out.println("</h3></center>");
            out.println("</div>");
            out.println("<div><label class=\"topnav-right\"> © 1999-2022 Evently. All rights reserved. </label></div>");
            out.print("</body>");
            out.print("</html>");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Exception Caught: " + e);
        }
       
    }
    

}
