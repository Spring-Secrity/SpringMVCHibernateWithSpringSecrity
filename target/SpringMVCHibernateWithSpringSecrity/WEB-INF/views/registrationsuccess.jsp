<%--
  Created by IntelliJ IDEA.
  User: Anlu
  Date: 2018/1/7
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Confirmation Page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="generic-container">
    <%@include file="authheader.jsp" %>

    <div class="alert alert-success lead">
        ${success}
    </div>

    <span class="well floatRight">
			Go to <a href="<c:url value='/list' />">Users List</a>
		</span>
</div>
</body>

</html>
