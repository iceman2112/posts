<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp" />
<a class="button" href="<c:url value="/post/new" />">New</a>
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
            <td>${post.author.name}</td>
            <td>${post.content}</td>
            <td>
                <a class="button" href="<c:url value="/post/edit/${post.id}" />">Update</a>
                <a class="button" href="<c:url value="/post/delete/${post.id}" />">Delete</a>
                <a class="button" href="<c:url value="/post/view/${post.id}" />">View</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:import url="../footer.jsp" />