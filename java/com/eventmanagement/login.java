package com.eventmanagement;



import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class login {
    
    public static boolean validate(String User_Name, String User_Password) throws SQLException{
        boolean status = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conURL = DriverManager.getConnection("jdbc:mysql://localhost:3306/EVENTMANAGEMENT", "root", "root")) {
                PreparedStatement preparedStatement = 
                        conURL.prepareStatement("select * from plogin where user_name=? and user_password=?");
                preparedStatement.setString(1, User_Name);
                preparedStatement.setString(2, User_Password);
                ResultSet resultSet = preparedStatement.executeQuery();
                status = resultSet.next();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
}