<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<nav>
            <ul>
                <li> <a href="index.html">Home</a></li>  
                <li><a href="login.html">Login</a></li>
                <li><a href="new_customer.html">New Customer</a></li>
                <li><a href="transaction">Account activity</a></li>
                <li><a href="balance">Transactions</a></li>
            </ul> 

        </nav>
<p>Here is the information that you entered:</p>
<label>First Name:</label>
<span>${user.firstName}</span><br>
<label>Last Name:</label>
<span>${user.lastName}</span><br>
<label>Phone:</label>
<span>${user.phone}</span><br>
<label>Address:</label>
<span>${user.address}</span><br>
<label>City:</label>
<span>${user.city}</span><br>
<label>State:</label>
<span>${user.state}</span><br>
<label>Zip code:</label>
<span>${user.zipcode}</span><br>
<label>Email:</label>
<span>${user.email}</span><br>
<label>Username:</label>
<span>${user.username}</span><br>
<label>Password:</label>
<span>${user.password}</span><br>
<c:import url="/includes/footer.jsp" />