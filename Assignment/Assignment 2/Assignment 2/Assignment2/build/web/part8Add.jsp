<%-- 
    Document   : part8Add
    Created on : Feb 3, 2019, 3:14:42 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter Books Information</h1>
        <% int number = (int)request.getAttribute("number");%>
        <form action="part8Welcome" method="post">
            <table>
                <thead>
                    <tr>
                        <th>ISBN</th>
                        <th>Book Title</th>
                        <th>Author</th>
                        <th>Price</th>
                    </tr>
                </thead> 

                <%
                    for(int i = 0; i < number; i++){
                %>

                <tr>
                    <td>
                        <input type="text" name="isbn"/>
                    </td>
                    <td>
                        <input type="text" name="title"/>
                    </td>
                    <td>
                        <input type="text" name="author"/>
                    </td>
                    <td>
                        <input type="text" name="price"/>
                    </td>
                </tr>

                <%}%>
            </table>

            <input type="submit" name="submit" value="Add Books"/>
        </form>
    </body>
</html>
