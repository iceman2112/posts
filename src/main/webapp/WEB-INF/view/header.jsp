<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${contextPath}/resources" var="resPath" />

<html>
<head>
    <link href="${resPath}/style.css" rel="stylesheet" type="text/css" />
    <head>
<body>

<header>
    <ul id="top-menu">
        <li><a href="<c:url value="/"/>">Posts</a></li>
        <li><a href="<c:url value="/category"/>">Categories</a></li>
        <li><a href="<c:url value="/author"/>">Authors</a></li>
    </ul>
</header>
<div class="wrapper">