

<%@page import="toba.business.User"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>



<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <%	String firstName = null;
            String lastName = null;

            if (session != null) {
                User usr = (User)session.getAttribute("user");
                if (usr != null) {
                    firstName = usr.getFirstName();
                    lastName = usr.getLastName();
                }

                if ((firstName != null) && (lastName != null)) {%>
        <h1>Customer account information</h1>
        <nav>
            <ul>
                <li> <a href="index.html">Home</a></li>  
                <li><a href="login.html">Login</a></li>
                <li><a href="new_customer.html">New Customer</a></li>
                <li><a href="account_activity.html">Account activity</a></li>
                <li><a href="transaction.html">Transactions</a></li>
            </ul> 

        </nav>
        <p>Welcome back, <%out.print(firstName + " " + lastName);%></p>
        <%} else {%>
        <h1>Not logged in</h1>	
        <%}%>
        <%} else {%>
        <h1>Not logged in</h1>
        <%}%>


    </body>
</html>
<c:import url="/includes/footer.jsp" />