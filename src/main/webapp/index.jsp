<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 04/16/2019
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Uploading Form</title>
</head>
<body>
<h3>File Upload:</h3>
Select a file to upload: <br/>
<form action="upload" method="post" name="uploadForm" enctype="multipart/form-data">
    <p>
        <input name="uploadfile" type="file" size="50">
    </p>

    <p></p>
    <input name="submit" type="submit" value="Submit">
</form>
</body>
</html>