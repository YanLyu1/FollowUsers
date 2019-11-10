<%-- 
    Document   : registerUserAccount
    Created on : Apr 10, 2019, 11:28:36 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Your Account</title>
    </head>-->
<c:import url="header.jsp">
    <c:param name="title" value="register"/>
    <%--<c:param name="locale" value="zh_CN"/>--%>
    <c:param name="h3" value="Register a new ACCOUNT"/>
    <%--<c:param name="locale" value="en_US"/>--%>
    <c:param name="locale" value="${language}"/>
</c:import>

<!--passwor double check-->
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

    <body>
        <h1>Input Your Information</h1>
        <h1>You Can get your new account</h1>
        <form action="register.htm" method="post">
            <c:if test="${error ne null}">
                <c:out value="You can not use ${error} as your User Name!"/><br> 
            </c:if>
<div class="form-group">
    <label for="exampleInputEmail1">Email: </label><input class="form-control" placeholder="Enter Email" type="email" name="email" required><br>
</div>
<div class="form-group">
    <label for="exampleInputEmail1">Phone Number: </label><input class="form-control" placeholder="Phone Number" type="text" name="phoneNumber" required><br>
</div>
<div class="form-group">
    <label for="exampleInputEmail1">User Name: </label><input class="form-control" placeholder="User Name" type="text" name="userName" required><br>
</div>
<div class="form-group">
    <label for="exampleInputPassword1">Password: </label><input class="form-control" placeholder="Password" type="password" name="password" id="password" required><br>
</div>
<div class="form-group">
            <span id="tishi"></span><br/>
</div>
<div class="form-group">
    <label for="exampleInputPassword1">Password Again: </label><input class="form-control" placeholder="Password" type="password" name="password2" id="password2"  onkeyup="validate()" required><br>
</div>
<div class="form-group">
    <label for="exampleInputPassword1">Avatar Path: </label><input class="form-control" placeholder="Choose a photo" type="file" name="avatarPath" required><br>
</div>
<div class="form-group">
    <label for="exampleInputPassword1">Introduction: </label><input class="form-control" placeholder="Introduction" type="text" name="introduction" required><br>
</div>
            <input class="btn btn-primary btn-lg btn-block" type="submit" id="button" value="Create a New Account"/>
            <input type="hidden" name="registerAction" value="true"/>
        </form>
    </body>
    <c:import url="footer.jsp"/>
</html>
