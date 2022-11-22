<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%System.out.println("ssssssssssssssssssssssssssssssssss");
String str = request.getParameter("htmlstr"); %>
<link href="../css/ht.css" rel="stylesheet" type="text/css">
<link href="../css/font.css" rel="stylesheet" type="text/css">
<title>消息框</title>
</head>
<script language="JavaScript" src="../js/ht.js"></script>
<script language="JavaScript" src="../js/Common.js"></script>
<body class="main_bg">
<div class="main_toolbar_bg"></div>
<div class="main_div">
<center>
<table height='130' width='300'><tr><td align='center' height='100%'>数据处理中，请稍候！</td></tr>
<tr><td align='center' height='100%'><font size='4'><%=str %></font></td></tr>
</table>
</center>
</div>
</body>
<script>
alert(1);
window.setTimeout("window.close();",50);
</script>
</html>