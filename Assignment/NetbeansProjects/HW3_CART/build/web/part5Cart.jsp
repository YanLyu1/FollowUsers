<%-- 
    Document   : part5Cart
    Created on : Feb 10, 2019, 5:37:27 PM
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping cart By JSTL & EL</title>
    </head>
    <body>
        <h1>Shopping cart By JSTL & EL</h1>
        
        <c:set var="productList" value="${sessionScope.products}"/>
        <table width="1000px" border="0">
            <tr>
                <td colspan="2" style="background-color:#FFA500;">
                    <h1>Shopping Cart</h1>
                </td>
            </tr>
            
            <tr>
                <td style="background-color:#FFD700;width:100px;vertical-align:top;">
                    <a href = "part5_book.jsp">Books</a><br>
                    <a href = "part5_music.jsp">Music</a><br>
                    <a href = "part5_computer.jsp">Computers</a>
                </td>
                <td style="background-color:#eeeeee;height:200px;width:400px;vertical-align:top;">
                    <p>The following items have been add to your cart successfully</p>
                    <form action="Part5Servlet" method="post">
                        <c:out value="Your books"/><br>
                        <label>
                            <c:forEach var="productItem" items="${productList.cart}">
                                <input type="checkbox" name="product" value="${productItem.name}"><c:out value="${productItem.name}"/><br>
                            </c:forEach>
                        </label>

                        <input type="submit" value="delete items"/>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
