package toba.login;

import java.io.IOException;

import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import toba.business.User;
import toba.data.UserDB;
import toba.business.Account;
import toba.data.AccountDB;
import toba.util.AccountType;


public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/new_customer.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/new_customer.html";    // the "join" page
        } else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipcode = request.getParameter("zipcode");
            String email = request.getParameter("email");

            // store data in User object
            User user = new User(firstName, lastName, phone, address, city, state, zipcode, email);

            // validate the parameters
            String message;
            if (firstName == null || lastName == null || phone == null || address == null || city == null || state == null || zipcode == null || email == null
                    || firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || zipcode.isEmpty() || email.isEmpty()) {
                message = "Please fill out all the form fields.";
                url = "/new_customer.html";
            } else {
                message = "";
                url = "/success.jsp";
                UserDB.insert(user); 
                
                //Create New Accounts
                Account savings = new Account( user, new BigDecimal(25.00), AccountType.SAVING);
                Account checking = new Account( user, new BigDecimal(0.00), AccountType.CHECKING);
                
                 
                AccountDB.insert( savings); 
                AccountDB.insert( checking);
                
                //store the User object as a session attribute
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                

            }
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
