/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        //get request parameters for userID and password
        String user = request.getParameter("username");
        String pwd = request.getParameter("password");
         
        //get servlet config init params
        String userID = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
        //logging example
        log("Username="+user+"::password="+pwd);
         
        if(userID.equals(user) && password.equals(pwd)){
            response.sendRedirect("Account_activity.html");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login_failure.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
             
        }
    }
}
    