<!DOCTYPE html>
<html>
    <head>
        <script>
            function handleEvent() {
                var divElem = document.getElementById("div1");
                var xmlHttp;

                try     // Firefox, Opera 8.0+, Safari
                {
                    xmlHttp = new XMLHttpRequest();
                }
                catch (e)
                {
                    try  // Internet Explorer
                    {
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    }
                    catch (e)
                    {
                        try
                        {
                            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                        }
                        catch (e)
                        {
                            alert("Your browser does not support AJAX!");
                            return false;
                        }
                    }
                }

                var textBoxUser = document.getElementById("user");
                
                //CALL THE SERVER-SIDE SCRIPT
                xmlHttp.open("POST", "user.htm", true);
                xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                xmlHttp.send("user=" + textBoxUser.value);
                
                //WAIT FOR THE SERVER-SIDE TO RESPOND
                xmlHttp.onreadystatechange=function()
                {
                    if(xmlHttp.readyState == 4) {
                        divElem.innerHTML = xmlHttp.responseText
                    }
                }



            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <input type="text" name="user" id="user" onkeyup="handleEvent()">
        <hr/>
        <div id="div1"></div>
    </body>
</html>
