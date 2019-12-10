<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>
<%@ page import="service.UserService" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.12.2019
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<User> users = UserService.getUserService().readAllUsers();
    request.setAttribute("users", users);
%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8" />
</head>
    <body>
    <table border="1px" cellpadding="5">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>password</th>
                <th>age</th>
            </tr>
            <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.age}"/></td>
            </tr>
                </form>
                <form method="get" action="update.jsp">
                    <td>
                        <button type="submit" name="id" value="${user.id}">Edit</button>
                    </td>
                </form>
                <form method="post" action="/deleteservlet">
                    <td>
                        <button type="submit" name="id" value="${user.id}">Delete</button>
                    </td>
                </form>
            </c:forEach>

        <form method="post" action="/createservlet">
        <tr>
            <td><label>Имя<input type="text" name="name"></label></td>
            <td><label>Пароль<input type="text" name="password"></label></td>
            <td><label>Возраст<input type="text" name="age"></label></td>
            <td><input type="submit" value="Ok" name="Ok"></td>
        </tr>

    </table>
    </body>
</html>
