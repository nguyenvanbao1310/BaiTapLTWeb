<%-- 
    Document   : survey
    Created on : Sep 20, 2024, 5:53:58 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url ="/include/header.html"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/survey.css" type="text/css"/>
    </head>
    <body>
        <h1>Thanks for taking our survey!</h1>
        <p>Here is the information that you entered:</p>
            <label><b>Email:</b></label>
            <span>${user.email}</span><br>

            <label><b>First Name:</b></label>
            <span>${user.firstName}</span><br>

            <label><b>Last Name:</b></label>
            <span>${user.lastName}</span><br>

            <label><b>Heard From:</b></label>
            <span>${user.radio}</span><br>
             
            <label><b>Updates:</b></label>
            <span>${user.check}</span><br>
            
            <label><b>Contact Via:</b></label>
            
            <c:if test="${not empty user.check}">
                <span>${user.option}</span><br>
            </c:if>
            <c:if test="${empty user.check}">
                <span>No option selected</span><br>
            </c:if>

            
           

        <p>To enter another email address, click on the Back button in your 
            browser or the Return button shown below.
        </p>
        
        <form action ="" method="get">
            <input type="hidden" name ="action" value="join">
            <input type="submit" value="Return">
        </form>
        
    </body>
</html>
