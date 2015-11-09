<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<html>
    <head>
        <meta charset="utf-8">
        <title>Reset password page</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
    </head>
    <body>
        <div>Please reset your password</div>
        <nav>
            <ul>
                <li> <a href="index.html">Home</a></li>  
                <li><a href="login.html">Login</a></li>
                <li><a href="new_customer.html">New Customer</a></li>
                <li><a href="account_activity.html">Account activity</a></li>
                <li><a href="transaction.html">Transactions</a></li>
            </ul> 

        </nav>

        <form action="reset" method="post">
            <input type="hidden" name="action" value="add">        
            <label class="pad_top">Old password:</label>
            <input type="password" name="passwordOld" required><br>
            <label class="pad_top">New password:</label>
            <input type="password" name="passwordNew" required><br>
            <label>&nbsp;</label>
            <input type="submit" value="Reset" class="margin_left">
            
        </form>

    </body>
</html>
<c:import url="/includes/footer.jsp" />






