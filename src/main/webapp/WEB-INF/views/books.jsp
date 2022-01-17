<%--
  Created by IntelliJ IDEA.
  User: mskeu
  Date: 2022-01-07
  Time: 오후 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>id</th>
    <th>bookname</th>
    <th>publisher</th>
    <th>price</th>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.bookid}</td>
            <td>${book.bookname}</td>
            <td>${book.publisher}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>