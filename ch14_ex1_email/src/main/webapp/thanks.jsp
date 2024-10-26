<%-- 
    Document   : thanks
    Created on : Sep 10, 2024, 5:21:44?PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url ="/include/header.html"/>
        <h1>Thanks for joining our email list</h1>
        <p>Here is the information that you entered</p>
        
        <label>Email:</label>
        <span>${user.email}</span><br>
        
        <label>First Name:</label>
        <span>${user.firstName}</span><br>
        
        <label>Last Name:</label>
        <span>${user.lastName}</span><br>
        
        <p>To enter another email address, click on the Back button in your 
            browser or the Return button shown below.
        </p>
        
        <form action ="" method="get">
            <input type="hidden" name ="action" value="join">
            <input type="submit" value="Return">
        </form>
        <p><i> ${sucessMessage}<i></p>
        <p><i> ${errorMessage}<i></p>
<c:import url ="/include/footer.jsp"/>