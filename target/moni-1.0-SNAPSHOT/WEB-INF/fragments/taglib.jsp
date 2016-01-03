<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
 
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"> 

<!-- jQuery -->
<script type="text/javascript" src="${baseURL}/resources/js/libs/jquery-1.11.3.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link type="text/css" rel="stylesheet" href="${baseURL}/resources/css/bootstrap.min.css">

<!-- Optional theme -->
<link type="text/css" rel="stylesheet" href="${baseURL}/resources/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="${baseURL}/resources/js/libs/bootstrap.min.js"></script>

<!-- Style -->
<link type="text/css" href="${baseURL}/resources/css/style.css">

<!-- Data Table -->
<link type="text/css" href="${baseURL}/resources/css/jquery.dataTables.min.css">
<link type="text/css" href="${baseURL}/resources/css/dataTables.bootstrap.min.css">
<script type="text/javascript" src="${baseURL}/resources/js/libs/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${baseURL}/resources/js/libs/dataTables.bootstrap.min.js"></script>

<!-- Angular JS -->
<script type="text/javascript" src="${baseURL}/resources/js/libs/angular.min.js"></script>

<!-- App moni -->
<script type="text/javascript" src="${baseURL}/resources/js/angular.app.js"></script>