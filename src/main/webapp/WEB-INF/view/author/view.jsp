<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp" />
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td>ID</td>
        <td>${author.id}</td>
    </tr>
    <tr>
        <td>NAME</td>
        <td>${author.name}</td>
    </tr>
</table>
<c:import url="../footer.jsp" />