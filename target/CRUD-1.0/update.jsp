<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.12.2019
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%
    String id = request.getParameter("id");
    request.setAttribute("id", id);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="post" action="<c:url value='/updateservlet'/>">
    <tr>
        <td>Изменение пользователя</td>
        <td><label><input type="text" name= "id" value = ${id}></label>Id</td>
        <td><label><input type="text" name="name"></label>Имя</td>
        <td><label><input type="text" name="password"></label>Пароль</td>
        <td><label><input type="text" name="age"></label>Возраст</td>

        <td><input type="submit" value="Ok" name="Ok"></td>
    </tr>
</form>
</body>
</html>
