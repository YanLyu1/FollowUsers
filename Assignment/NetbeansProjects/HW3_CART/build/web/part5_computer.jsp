<%-- 
    Document   : part5_book
    Created on : Feb 12, 2019, 2:05:14 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Pojo.Product"%>
<%@page import="DAO.ProductDirectory"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="productDir" class="DAO.ProductDirectory" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
    
    <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>books</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    
    <body>
    <c:set var="productList" value="${productDir.getProducts()}" scope="application"/>
        <table width="1000px" border="0">
            <tr>
                <td colspan="2" style="background-color:#FFA500;">
                    <h1>Shop for books</h1>
                </td>
            </tr>

            <tr>
                <td style="background-color:#FFD700;width:100px;vertical-align:top;text-align:center"> Menu </td>
                <td style="background-color:#eeeeee;height:20px;vertical-align:top;text-align:right"><a href = "Part5Servlet" >cart</a></td>
            </tr>

            <tr>
                <td style="background-color:#FFD700;width:100px;vertical-align:top;">
                    <a href = "part5_book.jsp">Books</a><br>
                    <a href = "part5_music.jsp">Music</a><br>
                    <a href = "part5_computer.jsp">Computers</a>
                </td>
                <td style="background-color:#eeeeee;height:200px;width:400px;vertical-align:top;">
                    <form method  = "GET" action = "Part5Servlet">
                        <label>
                            <c:forEach var="product" items="${productList}">
                                <c:if test="${product.type == 'computer'}">
                                    <input type = 'checkbox' name = 'products' value = '${product.name}'>${product.name} [${product.price}]<br/>
                                </c:if>
                            </c:forEach>
                        </label>
                        <br/>
                        <input type="hidden" value="computers" name="option" />
                        <input type = "submit" value = "addComputers" name = 'add Computers'/>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
