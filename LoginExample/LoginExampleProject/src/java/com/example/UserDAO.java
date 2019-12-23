/*Data Access Object or DAO is the model 
It is use to retrieve data from database for an Object
In this case, it is retrieving data for User Object
*/
package com.example;

import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;
    
    public static UserBean login(UserBean bean){
        
        // preparing some objects for connection
        Statement stmt = null;
        
        String email = bean.getEmail();
        String password = bean.getPassword();
        String searchQuery = "select * from admin where adminEmail='" + email + "'AND password='" + password + "'";
        
        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your email is " + email);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);

        try {
        // connect to DB
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
        
            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please signup first");
                bean.setValid(false);
            }
            // if user exists set the isValid variable to true
            else if (more) {
                String adminName = rs.getString("adminName");
                System.out.println("Welcome " + adminName);
                bean.setAdminName(adminName);
                bean.setValid(true);
            }
        }
        catch(Exception e){
                System.out.println("Log In Failed: An exception has occured! " + e);
        }
        // some exception handling
        finally {
            if (rs != null) {
                try{                   
                    rs.close();
                }catch(Exception e){
                    stmt = null;
                }
            }
            if (currentCon != null) {
                try{
                    currentCon.close();
                }catch(Exception e){
                    
                }
                currentCon = null;
            }
        }
        return bean;
    }
}
