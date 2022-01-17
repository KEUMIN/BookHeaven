<%--
  Created by IntelliJ IDEA.
  User: mskeu
  Date: 2022-01-07
  Time: 오후 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">
    bookname: <input type="text" name="bookname" />
    publisher: <input type="text" name="publisher" />
    price: <input type="text" name="price" />
    <button type="submit">전송</button>
</form>
</body>
</html>
