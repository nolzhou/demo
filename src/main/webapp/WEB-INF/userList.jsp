<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有用户</title>
</head>
<body>
<a href="<s:url value="/home" />">返回首页</a>
<a href="<s:url value="/addNewUser" />">添加新用户</a>
    <div class="userList">
        <h1>全部用户</h1>
        <ul class="userList">
            <c:forEach items="${userList}" var="user" >
                <li id="user_<c:out value="${user.id}"/>">
                    <div class="name">用户名: <c:out value="${user.name}" /></div>
                    <div class="password">密码: <c:out value="${user.password}" /></div>
                    <div class="telephone">用户电话: <c:out value="${user.telephone}" /></div>
                    <div>
                        <a href="<s:url value="/delete/${user.id}"/>">删除</a>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>


</body>
</body>
</html>
