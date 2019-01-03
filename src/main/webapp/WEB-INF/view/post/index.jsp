<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="../header.jsp" />
<a class="button" href="<c:url value="/post/new" />"><spring:message code="button_new" /></a>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th>Author</th>
        <th>Content</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="post" items="${postList}">
        <tr>
            <td>${post.id}</td>
            <td>${post.category.name}</td>
            <td>${post.user.name}</td>
            <td>${post.content}</td>
            <td>
                <a class="button" href="<c:url value="/post/edit/${post.id}" />"><spring:message code="button_edit" /></a>
                <a class="button" href="<c:url value="/post/delete/${post.id}" />"><spring:message code="button_delete" /></a>
                <a class="button" href="<c:url value="/post/view/${post.id}" />"><spring:message code="button_view" /></a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:import url="../footer.jsp" />