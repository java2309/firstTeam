<%--
  Created by IntelliJ IDEA.
  User: 86152
  Date: 2023/7/25
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="UserUpdateServlet?id=${user.id}" method="post">
        姓名:<input type="text" name="username" value="${user.username}"><br>
        密码:<input type="text" name="password" value="${user.password}"><br>
        手机号:<input type="text" name="phone" value="${user.phone}"><br>
        性别:<input type="text" name="sex" value="${user.sex}"><br>
        邮箱:<input type="text" name="mail" value="${user.mail}"><br>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
