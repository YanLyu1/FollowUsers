<%-- 
    Document   : resetPassword
    Created on : 2019-4-22, 19:20:00
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>-->
<c:import url="header.jsp">
    <c:param name="title" value="reset password"/>
    <c:param name="h3" value="reset password"/>
    <c:param name="locale" value="${language}"/>
</c:import>
    <!--<body>-->
        <h1>${error}</h1>
        
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="modal-body">
    <div class="row">
        <div class="col-xs-12">
            <div class="well">
                <form action="fogetPassword.htm?step=reset" method="post">
                    <div class="form-group">
                        User Name: <input type="text" name="userName"/><br/>
                    </div>
                    <div class="form-group">
                        Email: <input type="text" name="email"/><br/>
                    </div>
                    <div class="form-group">
                        <label for="captchaCode" class="control-label">Retype the characters from the picture:</label>             
                        <%// Adding BotDetect Captcha to the page
                            Captcha captcha = Captcha.load(request, "CaptchaObject");
                            captcha.setUserInputID("captchaCode");
                            String captchaHtml = captcha.getHtml();
                            out.write(captchaHtml);
                        %> 
                        <input id="captchaCode" type="text" class="form-control" name="captchaCode" required="required"/>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="RESET"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
                    
            
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </body>
    <c:import url="footer.jsp"/>
</html>
