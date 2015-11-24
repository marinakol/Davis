package toba.login;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import toba.business.Account;
import toba.business.User;
import toba.util.AccountType;


public class TransferServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/transfer.jsp";

        
	 HttpSession session = request.getSession();
         User user = (User) session.getAttribute("user");
         
         
         Account savings = new Account( user, AccountType.Type.SAVING);
         Account checking = new Account( user, AccountType.Type.CHECKING);
        
         
         // store the Customer's Account Info
         session.setAttribute("savingsAccount", savings);
         session.setAttribute("checkingAccount", checking);
        
         getServletContext().getRequestDispatcher(url).forward(request, response);
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
