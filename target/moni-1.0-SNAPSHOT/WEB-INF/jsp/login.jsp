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
    </head>
    <body onload="document.loginForm.username.focus();"> 
        
        <div class="container" style="text-align: center;">
            
            <div class="row">
                <div id="login-box" class="col-md-5 col-lg-offset-3">

                    <h3>Login with Username and Password</h3>

                    <c:if test="${not empty error}">
                        <div class="error">${error}</div>
                    </c:if>
                    <c:if test="${not empty msg}">
                        <div class="msg">${msg}</div>
                    </c:if>

                    <form name='loginForm' action="<c:url value='/login' />" method='POST'>
                        <table class="table table-bordered">
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
                                <td><input name="submit" type="submit" value="Login" class="btn btn-primary" /></td>
                            </tr>
                        </table>

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        
                    </form> 
                </div>
            </div>
            <script type="text/javascript">
                var url = document.location.href;
                url = url[url.length - 1] == "/" ? url : window.location.href = url + "/";
            </script>
        </div>
                        
    </body>
</html>
