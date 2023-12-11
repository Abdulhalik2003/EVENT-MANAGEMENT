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


public class validateAd extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try (PrintWriter printWriterOut = response.getWriter()) {
          
            String userName = request.getParameter("Ausername");
            String userPassword = request.getParameter("Apassword");
            
            response.setContentType("text/html");
            
           
            String adminUserOne = "A101";
            String adminUserOnePassword = "Admin101";
            
            String adminUserTwo = "A202";
            String adminUserTwoPassword = "Admin202";
            
            String adminUserThree = "A303";
            String adminUserThreePassword = "Admin303";
            
            String adminUserFour = "A404";
            String adminUserFourPassword = "Admin404";
            
           
            if(userName.equals(adminUserOne) && userPassword.equals(adminUserOnePassword)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminevent.html");
                requestDispatcher.forward(request, response);
            }else if(userName.equals(adminUserTwo) && userPassword.equals(adminUserTwoPassword)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminevent.html");
                requestDispatcher.forward(request, response);
            }else if(userName.equals(adminUserThree) && userPassword.equals(adminUserThreePassword)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminevent.html");
                requestDispatcher.forward(request, response);
            }else if(userName.equals(adminUserFour) && userPassword.equals(adminUserFourPassword)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminevent.html");
                requestDispatcher.forward(request, response);
                
            }else{
                
                response.setContentType("text/html");  
                printWriterOut.println("<script type=\"text/javascript\">");  
                printWriterOut.println("alert('Please Enter Valid Username & Password for Admin!!!');");  
                printWriterOut.println("</script>");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Alogin.html");
                requestDispatcher.include(request, response);
            }
        }
    }

}
