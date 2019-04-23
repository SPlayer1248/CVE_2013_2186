<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 04/16/2019
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<div id="result">
    <h3>${requestScope["message"]}</h3>
    <h3>Username: ${requestScope["username"]}</h3>
    <h3>Full name: ${requestScope["fullname"]}</h3>
    <h3>Age: ${requestScope["age"]}</h3>
</div>

</body>
</html>
