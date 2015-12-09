<!DOCTYPE html>
<%@page import="toba.business.Account"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Transaction</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>

    </head>
    <body>
        
    <%  Account savLookup = (Account)session.getAttribute("savingsLookup");
        Account chkLookup = (Account)session.getAttribute("checkingLookup");
        String savBal = savLookup.getBalance().toString();
        String chkBal = chkLookup.getBalance().toString();
    %>
        <div>Transaction details</div>
        <nav>
            <ul>
                <li> <a href="index.html">Home</a></li>  
                <li><a href="login.html">Login</a></li>
                <li><a href="new_customer.html">New Customer</a></li>
                <li><a href="transaction">Account activity</a></li>
                <li><a href="balance">Transactions</a></li>
                <li> <a href="admin/login.html">Admin login</a></li>
            </ul>
            <p><a href="https://localhost:8443/TOBA/new_customer.html">Use secure connection</a></p>
            <p><a href="admin">View the Admin applications</a></p>
    
            <p> -- Account Balance --</p>
            <p>Checking Account Balance $<%out.print(chkBal);%></p>
            <p>Savings Account Balance $<%out.print(savBal);%></p>
    
            <form action="transfer" method="post">
	            <input type="hidden" name="action" value="transfer">        
	            <label class="pad_top">From:</label>
	            <input type="radio" name="fromAccount" value="checking" required style="padding-right:5px">Checking
	            <input type="radio" name="fromAccount" value="saving" required>Savings
	            <br><br>
	            
	            <label class="pad_top">To:</label>
	            <input type="radio" name="toAccount" value="checking" required style="padding-right:5px">Checking
	            <input type="radio" name="toAccount" value="saving" required>Savings<br>
	            
	            $<input type="number" name="transferAmount" required><br>
	            
                    <input type="hidden" name="savBalance" value="<%out.print( savBal);%>" >
                    <input type="hidden" name="chkBalance" value="<%out.print( chkBal);%>" >
                    
	            <label>&nbsp;</label>
	            <input type="submit" value="Transfer Funds" class="margin_left">
        	</form> 

        </nav>
    </body>
</html>