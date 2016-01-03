<%-- 
    Document   : login
    Created on : Dec 23, 2015, 2:59:47 PM
    Author     : prongbang
--%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center;margin-top: 10em;">Hello World!</h1>
        <script type="text/javascript">
            var url = document.location.href;
            url = url[url.length-1] == "/" ? url : window.location.href = url + "/";
        </script>
        <p style="text-align: center;"><a href="./home">Home</a></p>
    </body>
</html>
