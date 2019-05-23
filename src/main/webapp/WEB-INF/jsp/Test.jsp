<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/doTest" method="post">
        用户名：<input type="text" name="uname" title="u">
        密码：<input type="text" name="pwd" title="p">
        <input type="submit" title="u">
    </form>
</body>
</html>
