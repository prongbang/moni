<%-- 
    Document   : errors
    Created on : Jan 13, 2016, 1:40:39 PM
    Author     : prongbang
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<!DOCTYPE html>
<html>
    <head> 
        <meta charset="utf-8">
        <title>${errorMessage}! :(</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="${baseURL}/resources/js/libs/jquery-1.11.3.min.js"></script>
        <style type="text/css">
            body {padding: 0px;margin: 0px;transition: margin 0.3s ease 0s, transform 0.3s ease 0s;font-family: "Open Sans", "Helvetica Neue", "Helvetica", "Arial", sans-serif;background: none repeat scroll 0% 0% #f9f9f9;color: #555;}
            .item {text-align: center;}
            div#container {margin-left: auto;margin-right: auto;}
            #size {font-size: 3.5em;}
            .pagefooter {width: 100%;height: 50px;position: fixed;bottom: 0;text-align: center;}
        </style> 
    </head> 
    <body>
        <article>
            <div id="container">
                <div class="item">
                    <div>
                        <h1 id="size">${errorMessage}! :(</h1>
                    </div>
                </div>
            </div>
        </article>
        <footer class="pagefooter">
            <p><span style="font-size: 0.7em;" id="footlabel"></span></p>
        </footer>
        <script type="text/javascript">$(function() { $('#footlabel').text("MONI " + (((new Date).getFullYear() == "2014")? "2014":"2014-" + ((new Date).getFullYear()))); $('#container').center(); }); jQuery.fn.center = function() { this.css("position", "absolute"); this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px"); this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px"); return this; };</script>
    </body> 
</html>
