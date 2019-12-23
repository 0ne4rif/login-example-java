<%@ page language="java"
 contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"
 import="com.example.UserBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
            content="text/html; charset=windows-1256">
    <title> User Logged Successfully </title>
    </head>
    <body>
    <center>
         <% UserBean currentUser = (UserBean) session.getAttribute("currentSessionUser"); %>
         Welcome <%= currentUser.getAdminName() %>
    </center>
     </body>
 </html>
