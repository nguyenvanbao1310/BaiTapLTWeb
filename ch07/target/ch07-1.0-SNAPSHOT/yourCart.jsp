<%-- 
    Document   : yourCart
    Created on : Sep 25, 2024, 11:44:04 AM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Styles/main.css" type="text/css"/>
    </head>
    <body>
        <h2>Your Cart</h2>
        <table>
            <thead>
              <tr>
                <th scope="col" class = "col0">Quantity</th>
                <th scope="col" class="col1">Description</th>
                <th scope="col" class = "col2">Price</th>
                <th scope="col" class="col3">Amount</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="a" items="${cart.getCart()}">
                    <tr>
                        <td class="quantity">
                            <form action ="" method="post">
                                <input type="hidden" name ="action" value="update">
                                <input type ="hidden" name ="productId" value="${a.pro.proId}">
                                <input type = "text"  name= "quantity" style="width: 1em;" value="${a.quantity}">
                                <button type="submit">Update</button>
                            </form>
                        </td>
                        <td class="name">${a.pro.name}</td>
                        <td class = "price"> ${a.pro.price}</td>
                        <td class = "amount">
                            <c:set var = "amount" value = "${a.pro.price * a.quantity }"/>
                            <fmt:formatNumber value="${amount}" pattern="0.00"/>
                        </td>                      
                        <td>
                            <form action ="" method="post">
                                <input type="hidden" name ="action" value="remove">
                                <input type ="hidden" name ="productId" value="${a.pro.proId}">                               
                                <button type="submit">Remove Item</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><b>To change the quantity</b>, enter the new quantity and click on the update button</p>
        <form action ="" method="get">
           <input type="hidden" name ="action" value="join">
           <input type="submit" style="margin-bottom:0.5em;"value="Continue Shopping">
        </form>
        <form action ="" method="post">
           <input type="hidden" name ="action" value="checkout">
           <button type="submit">Checkout</button>
        </form>
    </body>
</html>
