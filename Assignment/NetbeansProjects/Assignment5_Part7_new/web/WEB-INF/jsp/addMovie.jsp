<%-- 
    Document   : welcome
    Created on : Mar 9, 2019, 12:44:05 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Our Movie Store</h1>
        <h2>Assignment 5 Part_6</h2>
        <p>Add a Now Movie</p>
        <form:form commandName="movie" method = "post">
            <label> title :  </label><form:input path="title" type="text"/><form:errors path="title"/><br>
            <label> actor :  </label><form:input path="actor" type="text"/><form:errors path="actor"/><br>
            <label> actress :  </label><form:input path="actress" type="text"/><form:errors path="actress"/><br>
            <label> genre :  </label><form:input path="genre" type="text" /><form:errors path="genre"/><br>
            <label> year :  </label><form:input path="year" type="text" /><form:errors path="year"/><br>
            <input type="hidden" path="addmovie" value="addmovie" name="option" /><br>
            <input type="submit"  value="Add Movie"/> 
        </form:form>
    </body>
</html>
