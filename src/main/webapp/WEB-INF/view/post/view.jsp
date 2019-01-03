<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp" />
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td>ID</td>
        <td>${post.id}</td>
    </tr>
    <tr>
        <td>CATEGORY</td>
        <td>${post.category.name}</td>
    </tr>

    <tr>
        <td>AUTHOR</td>
        <td>${post.user.name}</td>
    </tr>

    <tr>
        <td>CONTENT</td>
        <td>${post.content}</td>
    </tr>
</table>
<c:import url="../footer.jsp" />