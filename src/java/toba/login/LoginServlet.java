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
import javax.servlet.http.HttpSession;
import toba.business.User;
import toba.data.UserDB;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("username");
        String pwd = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("username", user);
        session.setAttribute("password", pwd);

        if (!pwd.equals("welcome1")) {
            getServletContext().getRequestDispatcher("/login.html").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/password_reset.jsp").forward(request, response);
        }
    }

}
