<%-- 
    Document   : WriteArticle
    Created on : Apr 11, 2019, 6:23:25 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:import url="header.jsp">
    <c:param name="title" value="Upload"/>
    <c:param name="h3" value="Upload an article"/>
    <c:param name="locale" value="${language}"/>
</c:import>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create your articles here</title>
    </head>-->
    <body>
        <script>
            function showCustomer(str){
                var xmlhttp;    
                if (str==""){
                    document.getElementById("txtHint").innerHTML="";
                    return;
                }
                if (window.XMLHttpRequest){
                    xmlhttp=new XMLHttpRequest();
                }else{
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange=function(){
                    if (xmlhttp.readyState==4 && xmlhttp.status==200){
                        document.getElementById("show").innerHTML=xmlhttp.responseText;
                    }
                }
                xmlhttp.open("GET","test.htm?q="+str, true);
                xmlhttp.send();
                }
        </script>
        
        <script language="javascript">
            function sumbit_form(){
                var gnl=confirm("Please Confirm To Change User Status?");
                if (gnl==true){
                    return true;
                }else{
                    return false;
                }
            }
        </script>
        
        <script>
            function catNull(){
                var cat = document.getElementById("cat").value;
//                var gnl=confirm(cat);
                if(cat.equals("")){
                    alert(cat);
                    return false;
                }
            }
        </script>
        
        
<!--        <c:if test="${writeArticle == null}">
            <h1>NULL</h1>
        </c:if>
        <c:if test="${writeArticle != null}">
            <h1>NOT NULL</h1>
        </c:if>-->
            
        <!--<h1>${writeArticle}</h1>-->
        <!--<form action="uploadArticle.htm" method="post" enctype="multipart/form-data">-->
        
        <br/><br/>
            <c:if test="${article ne null}">
                <form action="uploadArticle.htm?articleAction=edit&step=submit&articleId=${article.articleId}" method="post" >
                    <div class="form-group">
                        <label for="exampleInputEmail1">title: </label><input class="form-control" type="text" name="title" value="${article.title}" required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">content: </label><textarea class="form-control" name="conten1" required>${article.content}</textarea>
                    </div>
                    <div class="form-group">   
                    <input type="radio" name="pubpri" value="true" checked/><label for="exampleInputEmail1">PUBLIC </label>
                    <input type="radio" name="pubpri" value="false" /><label for="exampleInputEmail1">PRIVATE </label>
                    <br/>
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Edit Article" onclick="return sumbit_form()"/>
                </form>
            </c:if>
             
            <c:if test="${article == null}">
            <form action="uploadArticle.htm?articleAction=write" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">title: </label><input class="form-control" type="text" name="title"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">content: </label><textarea class="form-control" name="content" cols="30" rows="4"></textarea><br>
                </div>
                <div class="form-group">                
                    <label for="exampleInputEmail1">Image: </label><input class="form-control" type="file" name="image"/>
                </div>
                <div class="dropdown">
                <select name="category" class="form-control" required>
                    <c:forEach var="category" items="${user.categoryList}">
                        <option value="${category.categoryId}">${category.category}</option>
                    </c:forEach>
                </select>
                </div>
                    <br/>
                <div class="form-group">   
                    <input type="radio" name="pubpri" value="true" checked/><label for="exampleInputEmail1">PUBLIC </label>
                    <input type="radio" name="pubpri" value="false" /><label for="exampleInputEmail1">PRIVATE </label>
                    <br/>
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Upload Article"/>
            </form>
            <br/><br/>
            <form action="addCategory.htm" method="get">
                <label for="exampleInputEmail1">add a category: </label><input class="form-control" id="cat" type="text" name="ac" required/>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="ADD CATEGORY" required/>
            </form>
            </c:if>  
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </body>
    <c:import url="footer.jsp"/>
</html>
