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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import toba.business.User;
import toba.data.UserDB;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get request parameters for userID and password
        String user = request.getParameter("username");
        String pwd = request.getParameter("password");

        //get servlet config init params
        String userID = "jsmith@toba.com";

        String password = "letmein";

        System.out.println("Username=" + user + "::pwd=" + pwd + " UserID: " + userID + "password: " + password);

        if (userID.equals(user) && password.equals(pwd)) {
            response.sendRedirect("account_activity.html");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login_failure.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
