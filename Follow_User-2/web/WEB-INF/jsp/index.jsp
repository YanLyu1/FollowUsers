<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


    <c:import url="header.jsp">
        <c:param name="title" value="Welcome"/>
        <c:param name="h3" value="Welcome"/>
        <c:param name="locale" value="${language}"/>
    </c:import>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>-->
<!--        <h1>log in</h1>
        <a href="login.htm">Log in</a>
        <h1>Register</h1>
        <a href="register.htm">Register</a>-->
        <script>
            function showCustomer(str)
            {
              var xmlhttp;    
              if (str=="")
              {
                document.getElementById("txtHint").innerHTML="";
                return;
              }
              if (window.XMLHttpRequest)
              {
                // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlhttp=new XMLHttpRequest();
              }
              else
              {
                // IE6, IE5 浏览器执行代码
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
              }
              xmlhttp.onreadystatechange=function()
              {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                  document.getElementById("show").innerHTML=xmlhttp.responseText;
                }
              }
              xmlhttp.open("GET","test.htm?q="+str, true);
              xmlhttp.send();
            }
        </script>

    <body>
        <input type="text" name="city" id="city" onkeydown="showCustomer(this.value)"/>
        <div id="show">  
        </div>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </body>
    
    <c:import url="footer.jsp"/>
</html>
