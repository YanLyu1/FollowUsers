<%-- 
    Document   : header
    Created on : 2019-4-14, 20:18:07
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--<html>-->
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
                <title>${param.title}</title>
		<!-- Bootstrap Core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom Fonts -->
		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<!-- Custom CSS -->
		<link rel="stylesheet" href="css/patros.css" >
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
                <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
                <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
                <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
                <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
		
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
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
			
	</head>

	<body data-spy="scroll">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                    <form method="get" action="search.htm">						
                                        Search:<input type="text" name="keyword" id="city" onkeydown="showCustomer(this.value)"/>
                                         <!--<input type="text" name="city" id="city" onkeydown="showCustomer(this.value)"/>-->
                                        <input type="submit" value="Search Article" onkeypress="showCustomer(this.value)"/>
                                        <div id="show">
                                    </form>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                    
					<ul class="nav navbar-nav navbar-right custom-menu">
                                            
                                            <fmt:setLocale value="${param.locale}"/>
                                            <fmt:bundle basename="i18n/website">
                                                <!--<li class="active"><a href="navigation.htm?navigation=home"><fmt:message key="label.home"/></a></li>-->
                                                <li class="active"><a href="navigation.htm?navigation=pagination"><fmt:message key="label.home"/></a></li>
                                                <li><a href="uploadArticle.htm?"><fmt:message key="label.upload"/></a></li>
                                                <li><a href="browseArticle.htm?articleAction=browse"><fmt:message key="label.articles"/></a></li>
                                                <li><a href="browseFriends.htm?browseAction=friends"><fmt:message key="label.friends"/></a></li>
                                                <li><a href="browseFans.htm?browseAction=fans"><fmt:message key="label.fans"/></a></li>
                                                <li><a href="resetInformation.htm"><fmt:message key="label.information"/></a></li>
                                                <li>
                                                    <a href="changeLanguage.htm?language=zh_CN">Chinese</a>
                                                    <a href="changeLanguage.htm?language=en_US">English</a>
                                                </li>
                                                <c:if test="${user != null}">
                                                <li><a href="login.htm?loginAction=out"><fmt:message key="label.logout"/></a></li>
                                                </c:if>
                                                <c:if test="${user == null}">
                                                <li><a href="login.htm"><fmt:message key="label.login"/></a></li>
                                                </c:if>
                                            </fmt:bundle>
                                            
					</ul>
				</div>
			</div>
		</nav>
                
                                            <c:if test="${param.h3 ne null}">
                                                <c:set var="h3Value" value="${param.h3}"/>
                                            </c:if>
                                            <c:if test="${param.h3 == null}">
                                                <c:set var="h3Value" value="Record & share"/>
                                            </c:if>
                                            
		<!-- Header Carousel -->
		<header id="home" class="carousel slide">
			<ul class="cb-slideshow">
				<li><span>image1</span>
					<div class="container">
						<div class="row">
							<div class="col-lg-12">
								<div class="text-center"><h3>${h3Value}</h3></div>
							</div>
						</div>
						<h4>Record Your Life From HERE!</h4>
					</div>
				</li>
				<li><span>image2</span>
					<div class="container">
						<div class="row">
							<div class="col-lg-12">
								<div class="text-center"><h3>${h3Value}</h3></div>
							</div>
						</div>
						<h4>Record Your Life From HERE!</h4>
					</div>
				</li>
				<li><span>image3</span>
					<div class="container">
						<div class="row">
							<div class="col-lg-12">
								<div class="text-center"><h3>${h3Value}</h3></div>
							</div>
						</div>
						<h4>Record Your Life From HERE!</h4>
					</div>
				</li>
				<li><span>Image 04</span>
					<div class="container">
						<div class="row">
							<div class="col-lg-12">
								<div class="text-center"><h3>${h3Value}</h3></div>
							</div>
						</div>
						<h4>Record Your Life From HERE!</h4>
					</div>
				</li>
				<li><span>Image 05</span>
					<div class="container">
						<div class="row">
							<div class="col-lg-12">
								<div class="text-center"><h3>${h3Value}</h3></div>
							</div>
						</div>
						<h4>Record Your Life From HERE!</h4>
					</div>
				</li>
				<li><span>Image 06</span>
					<div class="container">
						<div class="row">
							<div class="col-lg-12">
								<div class="text-center"><h3>${h3Value}</h3></div>
							</div>
						</div>
						<h4>Record Your Life From HERE!</h4>
					</div>
				</li>
			</ul>
<!--			<div class="intro-scroller">
				<a class="inner-link" href="home.htm">
					<div class="mouse-icon" style="opacity: 1;">
						<div class="wheel"></div>
					</div>
				</a> 
			</div>          -->
		</header>            