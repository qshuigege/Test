<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<meta name="description" content="slick Login">
<meta name="author" content="Webdesigntuts+">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/AdminLTE-2.3.5/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="js/ztree_v3/css/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/AdminLTE-2.3.5/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree_v3/js/jquery.ztree.core.min.js"></script>
</head>
<body>
<form id="" action="${pageContext.request.contextPath}/controller/UserController/addUser.action" method="post">
<label for="userid">userid</label><input type="text" name="userid" class="placeholder" placeholder="用户名">
<label for="password">password</label><input type="password" name="password" class="placeholder" placeholder="密码">
<input type="submit" value="提交">
</form>
</body>
</html>
