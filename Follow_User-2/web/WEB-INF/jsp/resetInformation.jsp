<%-- 
    Document   : resetInformation
    Created on : 2019-4-23, 13:11:31
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>-->
    <c:import url="header.jsp">
        <c:param name="title" value="register"/>
        <%--<c:param name="locale" value="zh_CN"/>--%>
        <c:param name="h3" value="UPDATE INFORMATION"/>
        <%--<c:param name="locale" value="en_US"/>--%>
        <c:param name="locale" value="${language}"/>
    </c:import>
    
    

    <body>
        <script>
            function validate() {
                var pwd1 = document.getElementById("password").value;
                var pwd2 = document.getElementById("password2").value;

            <!-- 对比两次输入的密码 -->
                if(pwd1 == pwd2)
                 {
                    document.getElementById("tishi").innerHTML="<font color='green'>The password entered twice is the same</font>";
                    document.getElementById("button").disabled = false;
                 }
            else {
                    document.getElementById("tishi").innerHTML="<font color='red'>The password entered twice are different</font>";
                    document.getElementById("button").disabled = true;
                 }
            }
            </script>
            
        <h1> </h1>
        <form action="resetInformation.htm?resetInfor=information" method="post">
            <c:if test="${error ne null}">
                <c:out value="You can not use ${error} as your User Name!"/><br>
            </c:if>
            <div class="form-group">
                <label for="exampleInputEmail1">User Name: </label><input class="form-control" type="text" name="userName" value="${user.userName}" required><br>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Email: </label><input class="form-control" type="email" name="email" value="${user.email}"  required><br>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Phone Number: </label><input class="form-control" type="text" name="phoneNumber" value="${user.phoneNumber}" required><br>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Password: </label><input class="form-control" type="password" name="password" id="password" required><br>
            </div>
            <span id="tishi"></span><br/>
            <div class="form-group">
                <label for="exampleInputEmail1">Password Again: </label><input class="form-control" type="password" name="password2" id="password2"  onkeyup="validate()" required><br>
            </div>
            <div class="form-group">
            <!--Avatar Path: <input type="file" name="avatarPath" required><br>-->
            <label for="exampleInputEmail1">Introduction: </label><input class="form-control" type="text" name="introduction" value="${user.introduction}" required><br>
            </div>
            <input class="btn btn-primary btn-lg btn-block" type="submit" id="button" value="UPDATE INFORMATION"/>
            <input type="hidden" name="registerAction" value="true"/>
        </form>
            <h1></h1>
            
    </body>
     <c:import url="footer.jsp"/>
</html>
