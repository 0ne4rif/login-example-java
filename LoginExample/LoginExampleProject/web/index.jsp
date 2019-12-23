<%-- 
    Document   : index
    Created on : Dec 12, 2019, 6:21:50 PM
    Author     : 0ne4rif
    This is the view
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Login Page</title>
    </head>
    <body>
        <form action="LoginServlet">
            Please enter your email       
            <input type="text" name="email"/><br>         
            Please enter your password    
            <input type="text" name="password"/>        
            <input type="submit" value="submit">         
        </form>
    </body>
</html>
