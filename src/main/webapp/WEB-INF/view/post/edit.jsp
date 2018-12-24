<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="../header.jsp" />
<form:form action="${pageContext.request.contextPath}/post/new/" modelAttribute="post" method="post">
    <form:input path="id" type="hidden"/>


    <select name="categoryId">
        <option value="0" selected>Select category</option>
        <c:forEach items="${categoryList}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>

    <select name="authorId">
        <option value="0" selected>Select category</option>
        <c:forEach items="${authorList}" var="author"></audio>">
            <option value="${author.id}">${author.name}</option>
        </c:forEach>
    </select>

    <form:textarea path="content" />
    <input class="button" type="submit" value="Save" />
</form:form>
<c:import url="../footer.jsp"/>
