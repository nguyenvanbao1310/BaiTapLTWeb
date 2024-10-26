<%-- 
    Document   : footer
    Created on : Sep 20, 2024, 4:58:14 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
        <%  
            GregorianCalendar currentDate = new GregorianCalendar();
            int currentYear = currentDate.get(Calendar.YEAR);
        %>
        <p>&copy; Copyright <%= currentYear %> Mike Murach &amp; Associates</p>
    </body>
</html>

    </body>
</html>
