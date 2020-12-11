<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Quiz!</title>
    </head>
    <body>
        <h1>Welcome to Quiz!</h1>
        <c:set var="questionDir" value="${requestScope.questionDir}"/>
        <c:set var="questionNumber" value="${requestScope.questionnum}"/>
        <c:forEach var="question" items="${questionDir.questionlist}">
            <c:if test="${questionNumber == question.number}">
                <form action="${question.number + 1}.htm" method="post">
                    <c:out value="Question ${question.number}: ${question.topic}"/><br/>
                    <label>
                        <input type="radio" name = "answer" value="${question.ans1}" checked>${question.ans1}<br>
                        <input type="radio" name = "answer" value="${question.ans2}">${question.ans2}<br>
                        <input type="radio" name = "answer" value="${question.ans3}">${question.ans3}<br>
                        <input type="radio" name = "answer" value="${question.ans4}">${question.ans4}<br>
                        <input type="hidden" name="questionnum" value="${questionnum}"/>
                    </label>   
                    <input type="submit" value="Next"/>
                </form>
            </c:if>
        </c:forEach>
        
        <c:set var="answermap" value="${sessionScope.answerMap}"/>
        <c:if test="${answerMap != null}">
            <table>
                <th>number</th>
                <th>answer</th>
                <c:forEach var="answer" items="${answerMap}">
                    <tr>
                        <td>
                            ${answer.key}
                        </td>
                        <td>
                            ${answer.value}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>