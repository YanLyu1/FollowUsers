<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <c:if test="${page == 10}">
        <h1>Your Answers</h1>
        
    </c:if>
    
        <c:set var="question" value="${question}"/>
        
        <c:if test="${page ne 10}">
            <form:form commandName="answers" action="quiz-${question.number + 1}.htm" method="post">
                <c:out value="Question ${question.number}: ${question.topic}"/><br/>
                <c:out value="${requestScope.string}"/><br/>
                <c:set var="path" value="answer${question.number}"/>
                <label>
                <form:errors path="*" cssStyle="color:red"/><br/>
                <form:radiobutton path = "${path}" value="${question.ans1}"/>${question.ans1}<br>
                <form:radiobutton path = "${path}" value="${question.ans2}"/>${question.ans2}<br>
                <form:radiobutton path = "${path}" value="${question.ans3}"/>${question.ans3}<br>
                <form:radiobutton path = "${path}" value="${question.ans4}"/>${question.ans4}<br>
                </label>   
                <c:if test="${question.number > 1}">
                    <input type="submit" value="Previous" name="_target${question.number-2}"/>
                </c:if>
                <c:if test="${page ne 9}">
                    <input type="submit" value="Next" name="_target${question.number}" />
                </c:if>
                <c:if test="${page == 9}">
                    <input type="submit" value="Submit" name="_finish" />
                </c:if>
                <input type="submit" value="Cancle" name="_cancel" />  
            </form:form>
        </c:if>
            
        <c:if test="${page == 10}">
            <table>
                <th>Question Number</th>
                <th>Your choice</th>
                <c:forEach var="answer" items="${sessionScope.answerMap}">
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
