/* Servlet is the controller
LoginServlet handles the parameter it receive from our login form
We need to set out form action to LoginServlet in order to do this 
If we set our method as "get" in our form, we need to invoke the doGet() function
If we set our method as "post" in our form, we need to invoke the doPost() function
*/

package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)    
                        throws ServletException, java.io.IOException { 
        try{
            UserBean user = new UserBean();
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            
            user = UserDAO.login(user);
            
            if (user.isValid()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                
                response.sendRedirect("home.jsp"); // logged-in page
            }
            else{
                response.sendRedirect("invalidLogin.jsp"); // error page
            }
        }catch (Throwable e){
            System.out.println(e);
        }
    }
}
