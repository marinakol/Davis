<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<nav>
    <ul>
        <li> <a href="index.html">Home</a></li>  
        <li><a href="login.html">Login</a></li>
        <li><a href="new_customer.html">New Customer</a></li>
        <li><a href="account_activity.html">Account activity</a></li>
        <li><a href="transaction.html">Transactions</a></li>
    </ul> 

</nav>




<body>

    <% String message = (String) request.getAttribute("msg");
        Account sav = (Account) request.getAttribute("savingsAccount");
        Account chk = (Account) request.getAttribute("checkingAccount");
            if (message != null) { %>
    <h1 style="color:red; font-size:12px"><%out.print(message);%></h1>
    <%}%>

    <h1 style="text-font:12px">Transfer Complete!</h1>
    <p> -- Funds from Savings to Checking --</p>
    <p>Checking Account Balance $xxxx.xx</p>
    <p>Savings Account Balance $xxxxx.xx</p>

</body>
</html>
<c:import url="/includes/footer.jsp" />