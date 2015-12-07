/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.business.Account;
import toba.business.User;
import toba.data.AccountDB;
import toba.util.AccountType;


public class BalDtlsServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String url = "/transaction.jsp";

        try {
        // perform action and set URL to appropriate page
        // validate the parameters
        Account savingsLookup = AccountDB.select( user, AccountType.SAVING);
        Account checkingLookup= AccountDB.select( user, AccountType.CHECKING);
              
        session.setAttribute("savingsLookup", savingsLookup);
        session.setAttribute("checkingLookup", checkingLookup);
        getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
  
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
