<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<meta name="description" content="slick Login">
<meta name="author" content="Webdesigntuts+">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/AdminLTE-2.3.5/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ztree_v3/css/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/AdminLTE-2.3.5/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree_v3/js/jquery.ztree.core.min.js"></script>
</head>
<body>
<form id="" action="${pageContext.request.contextPath}/controller/UserController/addRole.action" method="post">
<label for="rolename">rolename</label><input type="text" name="rolename" class="placeholder" placeholder="角色名">
<label for="categoryname">categoryname</label><input type="text" name="categoryname" class="placeholder" placeholder="角色分类">
<label for="roledesc">roledesc</label><input type="text" name="roledesc" class="placeholder" placeholder="描述">
<input type="submit" value="提交">
</form>

<table>
	<tr>
		<th>aaa</th>
		<th>bbb</th>
		<th>ccc</th>
	</tr>
	<c:forEach var="item" items="${dataList}">
		<tr>
			<td>${item. }</td>
			<td>${item. }</td>
			<td>${item. }</td>
		</tr>
	</c:forEach>

</table>


<div></div>

</body>
</html>
