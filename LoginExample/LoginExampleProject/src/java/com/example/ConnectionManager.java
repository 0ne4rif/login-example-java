/* This connection manager handles the connection to the database 
*  Same as mysqli_connect($host, $user, $pass, $dbname) in PHP 
*/

package com.example;

import java.sql.*;
import java.util.*;
public class ConnectionManager {
    static Connection con;
    
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "toor";
    
    public static Connection getConnection(){
        try{
          
            Class.forName(DB_DRIVER);
         
            
            try{
              con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
              System.out.println("connected");
  
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return con;
    }
    
}
