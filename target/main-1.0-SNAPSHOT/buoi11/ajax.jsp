<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 26/11/25
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajax demo</h1>
<button onclick="clickData()">Click me</button>
<div id="result"></div>
</body>
<%--De su dung duoc ajax: bat buoc phai co jquery--%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
    function clickData() {
        $.ajax({
            url: "/api/sinh-vien/detail",
            type: 'GET',
            dataType: "json",
            success: function (response) {
                // khi api goi thanh cong
                document.getElementById("result").innerHTML= 
                    `MSSV:`+response.ma + `Ten:`+response.ten
            }, error: function () {
                document.getElementById("result").innerHTML = " Loi roi"
            }
        })
    }
</script>
</html>
