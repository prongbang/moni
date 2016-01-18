<%-- 
    Document   : book
    Created on : Jan 1, 2016, 9:33:23 PM
    Author     : prongbang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/WEB-INF/fragments/taglib.jsp"/>
        <title>JSP Page</title>
        <!-- Load Script Controller -->
        <script type="text/javascript" src="${baseURL}/resources/js/book.controller.js"></script>
        <!-- /Load Script Controller -->
    </head>
    <body ng-app="moni">
        <jsp:include page="/WEB-INF/fragments/header.jsp"/>
        <div class="container" ng-controller="bookController">
            <h1>Book Manager</h1> 
            <table class="table" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:forEach items="${book}" var="b">
                                ${b.id+1}<input id="id" type="hidden" value="${b.id+1}" />
                            </c:forEach>
                        </td>
                        <td><input id="name" type="text" class="form-control" value="" placeholder="Name" /></td>
                        <td><input id="price" type="text" class="form-control" value="" placeholder="Price" /></td>
                        <td><button ng-click="add()"class="btn btn-primary">Add</button></td>
                    </tr>
                </tbody>
            </table>
            <hr/>
            <table id="books" class="table" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${books}" var="b">
                        <tr>
                            <td>${b.id}</td>
                            <td><c:out value="${b.name}"/></td>
                            <td><c:out value="${b.price}"/></td>
                            <td>
                                <form action="./delete" method="post">
                                    <input type="hidden" name="id" value="${b.id}" />
                                    <button type="submit" class="btn" onclick="return confirm('Delete ?')" title="Delete">X</button>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div>

        <jsp:include page="/WEB-INF/fragments/footer.jsp"/>

    </body>
</html>

