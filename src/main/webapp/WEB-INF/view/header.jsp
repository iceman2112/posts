<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${contextPath}/resources" var="resPath" />

<html>
<head>
    <link href="${resPath}/style.css" rel="stylesheet" type="text/css" />
    <style>
        body, ul{
            margin: 0;
            padding: 0;
        }

        body{
            background-color: beige;
        }

        .wrapper{
            padding: 0 15px;
        }

        .button{
            padding: 5px;
            text-transform: UPPERCASE;
            background-color: lightgreen;
            display: inline-block;
            margin: 5px 0;
        }

        #top-menu {
            list-style-type: none;
            background-color: lightgreen;
            margin-bottom: 20px;
        }

        #top-menu li{
            display:inline-block;
            padding: 20px 15px;
            font-size: 25px;
        }

        #top-menu a, #top-menu a:visited{
            text-decoration: none;
        }

        #top-menu li:hover, .button:hover{
            background-color: darkseagreen;
            cursor:pointer;
        }

        #top-menu a, #top-menu a:visited, body{
            color: maroon
        }

        th, td{
            padding: 15px;
            font-size: 15px;
        }
    </style>
    <head>
<body>

<header>
    <ul id="top-menu">
        <li><a href="<c:url value="/"/>">Posts</a></li>
        <li><a href="<c:url value="/category"/>">Categories</a></li>
        <li><a href="<c:url value="/author"/>">Authors</a></li>
        <c:set value="${sessionScope.get(\"userId\")}" var="userId" />
        <c:choose>
            <c:when test="${userId == null}">
                <li><a href="<c:url value="/auth/login"/>">Login</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="<c:url value="/auth/logout"/>">Logout</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</header>
<div class="wrapper">