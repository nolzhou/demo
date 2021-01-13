<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>添加新用户</title>
</head>
<body>
<a href="<s:url value="/userList" />">返回</a>
<h1>添加新用户</h1>
<form method="POST">
    用户名 : <input type="text" name="name" /><br />
    密  码 : <input type="password" name="password" /><br />
    电话号码: <input type="text" name="telephone" /><br />
    <input type="submit" value="确定" />
</form>
</body>
</html>
