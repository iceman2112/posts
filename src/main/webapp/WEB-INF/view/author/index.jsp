<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="../header.jsp" />
<a class="button" href="<c:url value="/author/new" />">New</a>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="post" items="${authorList}">
        <tr>
            <td>${post.id}</td>
            <td>${post.name}</td>
            <td>
                <a class="button" href="<c:url value="/author/edit/${post.id}" />">Update</a>
                <a class="button" href="<c:url value="/author/delete/${post.id}" />">Delete</a>
                <a class="button" href="<c:url value="/author/view/${post.id}" />">View</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:import url="../footer.jsp" />