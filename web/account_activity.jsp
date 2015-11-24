

<%@page import="toba.business.User"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>

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

        <c:choose>
            <c:when test="${not empty user}">
                <p>Hello, <c:out value='${user.firstName}'/> <c:out value='${user.lastName}' /></p>
            </c:when>
            <c:otherwise>
                <p>Please Log in</p>
            </c:otherwise>
        </c:choose>


    </body>
</html>
<c:import url="/includes/footer.jsp" />