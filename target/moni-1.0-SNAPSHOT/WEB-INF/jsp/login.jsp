<%-- 
    Document   : login
    Created on : Dec 23, 2015, 2:59:47 PM
    Author     : prongbang
--%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/WEB-INF/fragments/taglib.jsp"/>
        <title>JSP Page</title>
        <style>
            td{
                padding: 10px;
            }
        </style>
    </head>
    <body> 

        <div class="container" style="text-align: center;">

            <div class="row">
                <center>

                    <div id="login-box" style="margin-top: 13em;">   
                        <form action="<c:url value='/login' />" method='POST'>

                            <table class=""> 
                                <tr>
                                    <td><h3>Login</h3></td>
                                </tr>
                                <c:if test="${not empty error or not empty msg or not empty expired}">
                                <tr>
                                    <td colspan="2">
                                        <c:if test="${not empty error}">
                                            <div class="alert-danger">${error}</div>
                                        </c:if>
                                        <c:if test="${not empty msg}">
                                            <div class="alert-warning">${msg}</div>
                                        </c:if>
                                        <c:if test="${not empty expired}">
                                            <div class="alert-info">${expired}</div>
                                        </c:if>  
                                    </td>
                                </tr>
                                </c:if>
                                <tr>
                                    <td>Username</td>
                                    <td><input type='text' name='j_username' class="form-control" placeholder="Username" /></td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td><input type='password' name='j_password' class="form-control" placeholder="Password" /></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input name="submit" type="submit" value="Login" class="btn btn-primary" style="float: right;"></td>
                                </tr>
                            </table>

                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                        </form> 
                    </div>
                </center>
            </div>
            <script type="text/javascript">
                var url = document.location.href;
                //url = url[url.length - 1] == "/" ? url : window.location.href = url + "/";
            </script>
        </div>

    </body>
</html>
