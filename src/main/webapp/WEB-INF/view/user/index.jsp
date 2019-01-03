<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="../header.jsp" />
<a class="button" href="<c:url value="/user/new" />"><spring:message code="button_new" /></a>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="post" items="${userList}">
        <tr>
            <td>${post.id}</td>
            <td>${post.name}</td>
            <td>
                <a class="button" href="<c:url value="/user/edit/${post.id}" />"><spring:message code="button_edit" /></a>
                <a class="button" href="<c:url value="/user/delete/${post.id}" />"><spring:message code="button_delete" /></a>
                <a class="button" href="<c:url value="/user/view/${post.id}" />"><spring:message code="button_view" /></a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:import url="../footer.jsp" />