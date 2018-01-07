<%--
  Created by IntelliJ IDEA.
  User: Anlu
  Date: 2018/1/7
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="authbar">
    <span>Dear <strong>${loggedinuser}</strong>, Welcome to CrazyUsers.</span> <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
</div>
</body>
</html>
