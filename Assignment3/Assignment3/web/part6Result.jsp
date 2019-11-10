<%-- 
    Document   : part6Result.jsp
    Created on : Feb 10, 2019, 1:34:51 PM
    Author     : root
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 6 Result</title>
    </head>
    
    <body>
        <h1>Part 6 Result _ Connect to CSV File</h1>
        <body>
        <h2>Contents</h2>
        <table>
            <th>SalesOrderID</th>
            <th>RevisionNumber</th>
            <th>OrderDate</th>
            <th>DueDate</th>
            <th>ShipDate</th>
            <th>Status</th>
            <th>OnlineOrderFlag</th>
            <th>SalesOrderNumber</th>
            <th>PurchaseOrderNumber</th>
            <th>AccountNumber</th>
            <th>CustomerID</th>
            <th>SalesPersonID</th>
            <th>TerritoryID</th>
            <th>BillToAddressID</th>
            <th>ShipToAddressID</th>
            <th>ShipMethodID</th>
            <th>CreditCardID</th>
            <th>CreditCardApprovalCode</th>
            <th>CurrencyRateID</th>
            <th>SubTotal</th>
            <th>TaxAmt</th>
            <th>Freight</th>
            <th>TotalDue</th>
            <th>Comment</th>
            <th>ModifiedDate</th>
            <c:forEach var="item" items="${requestScope.list}">
                <tr>
                <td>
                    <c:out value="${item.salesOrderID}"/>
                </td>
                <td>
                    <c:out value="${item.revisionNumber}"/>
                </td>
                <td>
                    <c:out value="${item.orderDate}"/>
                </td>
                <td>
                    <c:out value="${item.dueDate}"/>
                </td>
                <td>
                    <c:out value="${item.shipDate}"/>
                </td>
                <td>
                    <c:out value="${item.status}"/>
                </td>
                <td>
                    <c:out value="${item.onlineOrderFlag}"/>
                </td>
                <td>
                    <c:out value="${item.salesOrderNumber}"/>
                </td>
                <td>
                    <c:out value="${item.purchaseOrderNumber}"/>
                </td>
                <td>
                    <c:out value="${item.accountNumber}"/>
                </td>
                <td>
                    <c:out value="${item.customerID}"/>
                </td>
                <td>
                    <c:out value="${item.salesPersonID}"/>
                </td>
                <td>
                    <c:out value="${item.territoryID}"/>
                </td>
                <td>
                    <c:out value="${item.billToAddressID}"/>
                </td>
                <td>
                    <c:out value="${item.shipToAddressID}"/>
                </td>
                <td>
                    <c:out value="${item.shipMethodID}"/>
                </td>
                <td>
                    <c:out value="${item.creditCardID}"/>
                </td>
                <td>
                    <c:out value="${item.creditCardApprovalCode}"/>
                </td>
                <td>
                    <c:out value="${item.currencyRateID}"/>
                </td>
                <td>
                    <c:out value="${item.subTotal}"/>
                </td>
                <td>
                    <c:out value="${item.taxAmt}"/>
                </td>
                <td>
                    <c:out value="${item.freight}"/>
                </td>
                <td>
                    <c:out value="${item.totalDue}"/>
                </td>
                <td>
                    <c:out value="${item.comment}"/>
                </td>
                <td>
                    <c:out value="${item.modifiedDate}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
    </body>
</html>
