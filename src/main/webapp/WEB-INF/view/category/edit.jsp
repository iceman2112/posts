<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forn" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="../header.jsp" />
<form:form action="${pageContext.request.contextPath}/category/new/" modelAttribute="category" method="post">
    <form:input path="id" type="hidden"/>
    <form:input path="name"/> <br />
    <input class="button" type="submit" value="Save" />
</form:form>
<c:import url="../footer.jsp"/>
