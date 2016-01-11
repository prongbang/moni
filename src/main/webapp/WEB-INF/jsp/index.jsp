<%-- 
    Document   : header
    Created on : Dec 23, 2015, 2:26:59 PM
    Author     : prongbang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/WEB-INF/fragments/taglib.jsp"/>
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body ng-app="moni">

        <jsp:include page="/WEB-INF/fragments/header.jsp"/>

        <div class="container"> 
            <div class="jumbotron">
                <h1>Hello, world!</h1>
                <p>This is the default welcome page for a Spring Web MVC project.</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
            </div>
        </div>

        <jsp:include page="/WEB-INF/fragments/footer.jsp"/>

        <!-- Load Script Controller -->
        <script type="text/javascript" src="./resources/js/home.controller.js"></script>
        <!-- /Load Script Controller -->

    </body>
</html>
