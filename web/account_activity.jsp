

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h1>Customer account information</h1>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${cookie.firstNameCookie.value != null} && ${cookie.lastNameCookie.value != null}">
    <p>Welcome back, <c:out value='${cookie.firstNameCookie.value}' + ${cookie.lastNameCookie.value}'/></p>
</c:if>
    </body>
</html>
<c:import url="/includes/footer.jsp" />