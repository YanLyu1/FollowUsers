<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="questionDir" class="com.hw5.dao.QuestionDirectory" scope="application"></jsp:useBean>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    
    <body>
        <c:set var="question" value="${question}"/>
        <%--<c:set var = "question" value="${questionDir.question1}"/>--%>
        <form action="quiz${question.number + 1}.htm" method="post">
                <c:out value="Question ${question.number}: ${question.topic}"/><br/>
                <c:out value="${requestScope.string}"/><br/>
                <label>
                <input type="radio" name = "answer" value="${question.ans1}" checked>${question.ans1}<br>
                <input type="radio" name = "answer" value="${question.ans2}">${question.ans2}<br>
                <input type="radio" name = "answer" value="${question.ans3}">${question.ans3}<br>
                <input type="radio" name = "answer" value="${question.ans4}">${question.ans4}<br>
                </label>   
                <input type="submit" value="Previous" name="_target${requestScope.page-1}" />
            <c:if test="${page ne 9}">
                <input type="submit" value="Next" name="_target${requestScope.page+1}" />
            </c:if>
            <c:if test="${page == 9}">
                <input type="submit" value="Submit" name="_finish" />
            </c:if>
            <input type="submit" value="Cancle" name="_cancel" />  
        </form>
            
            <c:set var="answers" value="${sessionScope.answerMap}"/>
            <table>
                <c:forEach var="answer" items="${answers}">
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
            
            
    </body>
</html>
