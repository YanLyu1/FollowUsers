<%-- 
    Document   : part4
    Created on : Feb 9, 2019, 5:09:28 PM
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page  language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<c:import url="./header.jsp">
    <c:param name="title" value="part4"></c:param>
</c:import>
        <h1>Core Tag Lib</h1>
        <c:set var="score" value="${param.score}"/>
            <p>Your score is: <c:out value="${score}"/></p>
        <c:if test="${score > 0}">
            <c:choose>
                <c:when test="${score < 60}">
                    <c:out value = "Continue to work hard."></c:out>
                </c:when>
                <c:when test="${score > 60 && score < 90}">
                    <c:out value="Good achievement!"></c:out>
                </c:when>
                <c:otherwise>
                    <c:out value="You are very smart."></c:out>
                </c:otherwise>
            </c:choose>
        </c:if>
                
        <h1>Formatting Tag Lib</h1>
        <h2>View Website in:</h2>
        <a href="?score=50&locale=en_US">English(US)   </a>
        <a href="?score=50&locale=zh_CN">Chinese (Simplified)   </a>
        <a href="?score=50&locale=hi_IN">Hindi   </a><br>
        <fmt:setLocale value="${param.locale}"/>
            <jsp:useBean id="now" class="java.util.Date" scope="page"/>
            <c:set var="date" value="${now}"></c:set>
            Date:  <fmt:formatDate type="date" value="${date}"/><br>
            Time:  <fmt:formatDate type="time" value="${date}"/><br>
        <fmt:bundle basename="i18n/i18n">
            <fmt:message key="label.hello"></fmt:message><br>
            <fmt:message key="label.language"></fmt:message><br>
            <fmt:message key="label.thanks"></fmt:message><br>
        </fmt:bundle>
            <fmt:formatNumber value="${1000}" type="currency"/><br>
        <c:out value="Now, your language is ${param.locale}."></c:out>
        
        <h1>JSTL Function Tag Lib</h1>
            <c:set var="string" value="WebTool_Assignemnt3_YanLyu_Part4"></c:set>
            <c:out value="the original stirng is:    ${string}"></c:out>
            <br><br>
            <c:out value="string before Assignment3 is:    ${fn:substringBefore(string,'Assignemnt3')}"></c:out>
            <br><br>
            <c:out value="string after Assignment3 is:   ${fn:substringAfter(string,'Assignemnt3')}"></c:out>
            <br><br>
            <c:out value="string between 5 and 10 is:   ${fn:substring(string,5,10)}"></c:out>
            <br><br>
            <c:set var="splits" value="${fn:split(string, '_')}"></c:set>
            <c:out value="the resutl of splitting every _ is: "></c:out>
                <c:forEach  var="split" items="${splits}">
                    ${split}
                </c:forEach>
            <br><br>
            <c:set var="join" value="${fn:join(splits,'*')}"></c:set>
            <c:out value="join with *: ${join}"></c:out>
            <br>
            
            
        <h1>SQL Tag Lib</h1>
        <sql:setDataSource var="database" driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost/booksdb"
                           user="root"  password="ly950223"/>

        <sql:query dataSource="${database}" sql="Select * from books" var="books" />
        <table border="1" cellspacing="0">
            <th>isbn</th>
            <th>title</th>
            <th>author</th>
            <th>price</th>
            <c:forEach var="book_rows" items="${books.rows}">
            <tr>
                <td>
                    <c:out value="${book_rows.isbn}"/>
                </td>
                <td>
                    <c:out value="${book_rows.title}"/>
                </td>
                <td>
                    <c:out value="${book_rows.author}"/> 
                </td>
                <td>
                    <c:out value="${book_rows.price}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
        <sql:update dataSource="${database}" var="insert">
            INSERT INTO books VALUES (20, 9, 9999, 99);
        </sql:update>
        

        <h1>XML Tag Lib</h1>
            <c:import url="part4_xmlTagLib.xml" var="xmlFile"></c:import>
            <x:parse xml="${xmlFile}" var="xmlParse"></x:parse>
            <table border="1" cellspacing="0">
                <th>name</th>
                <th>course</th>
                <th>score</th>
                <x:forEach select="$xmlParse/Students/Student">
                    <tr>
                        <x:if select="score >= 50">
                            <x:choose>
                                <x:when select="score < 80 ">
                                    <td bgcolor="red"><x:out select="name"></x:out></td>
                                    <td bgcolor="red"><x:out select="course"></x:out></td>
                                    <td bgcolor="red"><x:out select="score"></x:out></td>
                                </x:when>
                                <x:when select="score >= 80">
                                    <td bgcolor="yellow"><x:out select="name"></x:out></td>
                                    <td bgcolor="yellow"><x:out select="course"></x:out></td>
                                    <td bgcolor="yellow"><x:out select="score"></x:out></td>
                                </x:when>
                            </x:choose>
                        </x:if>
                    </tr>
                </x:forEach>
                    <tfoot>Arya is not displayed because of score less than 50!</tfoot>
            </table>
            
        
        
<c:import url="./footer.jsp">
    <c:param name="footer" value="part4"></c:param>
</c:import>
