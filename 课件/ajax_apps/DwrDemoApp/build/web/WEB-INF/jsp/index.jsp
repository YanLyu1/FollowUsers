<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <script src='/DwrDemoApp/dwr/engine.js'></script>
        <script src='/DwrDemoApp/dwr/interface/User.js'></script>
        <script>
            function f() {
                User.getData(100, {
                        callback:function(responseText) { 
                        document.getElementById("data").innerHTML = responseText;
                    }
                });
            }
        </script>
    </head>

    <body>
        <button onclick="f()">Get Details</button>
        <div id="data"></div>
    </body>
</html>
