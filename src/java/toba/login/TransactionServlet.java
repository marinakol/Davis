package toba.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.business.Account;
import toba.business.Transaction;
import toba.business.User;
import toba.data.AccountDB;
import toba.data.TransactionDB;
import toba.util.AccountType;


public class TransactionServlet extends HttpServlet {
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

           try {
               Account savingLookup = AccountDB.select( user, AccountType.SAVING);
               Account checkingLookup= AccountDB.select( user, AccountType.CHECKING);
               List<Transaction> transBlob = TransactionDB.select( user);

               request.setAttribute("totalSavingBalance", savingLookup.getBalance().toString());
               request.setAttribute("totalCheckingBalance", checkingLookup.getBalance().toString());
               request.setAttribute("transBlob", transBlob);

           } catch (Exception e) {
                   System.out.println("TransactionServlet Exception " + e.getMessage());
           }
           getServletContext().getRequestDispatcher("/account_activity.jsp").forward(request, response);

        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
