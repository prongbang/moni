<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<c:url value="/logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<nav class="navbar navbar-inverse" style="border-radius: 0px;"> 
    <div class="container-fluid">  
        <div class="navbar-header"> 
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false"> 
                <span class="sr-only">Toggle navigation</span> 
                <span class="icon-bar"></span> 
                <span class="icon-bar"></span> 
                <span class="icon-bar"></span> 
            </button> 
            <a class="navbar-brand" href="#">MONI</a> 
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9"> 
            <ul class="nav navbar-nav"> 
                <li class="active"><a href="${baseURL}/home">Home</a></li> 
                <li><a href="${baseURL}/book">Book</a></li> 
                <li><a href="${baseURL}/service/book" target="_blank">Book Service</a></li> 
            </ul> 
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <ul class="nav navbar-nav navbar-right">  
                    <li class="dropdown"> 
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${pageContext.request.userPrincipal.name} <span class="caret"></span></a> 
                        <ul class="dropdown-menu"> 
                            <li><a href="#">Profile</a></li>
                            <li><a href="javascript:formSubmit()"> Logout</a></li>
                        </ul> 
                    </li> 
                </ul>
            </c:if>
        </div>  
    </div> 
</nav>