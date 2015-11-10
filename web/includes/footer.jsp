<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
    GregorianCalendar currentDate = new GregorianCalendar();

    int currentMonth = currentDate.get(Calendar.MONTH);
    int currentDay = currentDate.get(Calendar.DATE);
    int currentYear = currentDate.get(Calendar.YEAR);
    String date = currentMonth + "/" + currentDay + "/" + currentYear;
%>
<p>&copy; Copyright <%=date%> Marina Davis</p>
</body>
</html>