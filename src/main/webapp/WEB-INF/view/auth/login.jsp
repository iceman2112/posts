<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="../header.jsp" />

<form action="${pageContext.request.contextPath}/auth/login" method="post">
    <table>
        <tr>
            <td>
                <label for="login">Login</label>
            </td>
            <td>
                <input name="login" id="login" />
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password</label>
            </td>
            <td>
                <input name="password" id="password" />
            </td>
        </tr>
        <td>
            <td colspan="2"><input type="submit" class="button" value="Login" /></td>
        </td>
    </table>

</form>

<c:import url="../footer.jsp" />