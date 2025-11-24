<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Xin chao: ${sessionScope.username}</p>
<select>
    <c:forEach items="${listCaSi}" var="cs">
        <option value="${cs.id}">${cs.tenCaSy}</option>
    </c:forEach>
</select>
<a href="/dang-xuat">Đăng xuất</a>
<table border="1" cellpadding="10" cellspacing="0">
    <thead>
    <tr>
        <th>STT</th>
        <th>Ten bai hat</th>
        <th>Ten tac gia</th>
        <th>Thoi luong</th>
        <th>Ten ca si</th>
        <th>Que quan</th>
        <th>SDT</th>
        <th>Ngay ra mat</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="i" items="${listBaiHat}"
               var="bh">
        <tr>
            <td>${i.index +1}</td>
            <td>${bh.tenBaiHat}</td>
            <td>${bh.tenTacGia}</td>
            <td>${bh.thoiLuong}</td>
            <td>${bh.caSi1.tenCaSy}</td>
            <td>${bh.caSi1.queQuan}</td>
            <td>${bh.caSi1.sdt}</td>
            <td>${bh.ngaySanXuat}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
