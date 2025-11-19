<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 19/11/25
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${test1}
    <br/>
   C1: ${bienSession}
    <br/>
    <%-- sessionScope: dung de goi    --%>
    C2: ${sessionScope.bienSession}
</body>
</html>
