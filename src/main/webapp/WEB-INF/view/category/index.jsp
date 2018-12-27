<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="../header.jsp" />
<a class="button" href="<c:url value="/category/new" />"><spring:message code="button_new" /></a>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="post" items="${categoryList}">
        <tr>
            <td>${post.id}</td>
            <td>${post.name}</td>
            <td>
                <a class="button" href="<c:url value="/category/edit/${post.id}" />"><spring:message code="button_edit" /></a>
                <a class="button" href="<c:url value="/category/delete/${post.id}" />"><spring:message code="button_delete" /></a>
                <a class="button" href="<c:url value="/category/view/${post.id}" />"><spring:message code="button_view" /></a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:import url="../footer.jsp" />