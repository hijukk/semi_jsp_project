<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	$(function() {
		console.log("onload");
	});
</script>
</head>
<body>
	<h1>index ${session_id}</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>

	<form action="JLoginOK.do" method="post">
		<input type="text" name="id" value="hiju"> <br>
		<input type="password" name="pw" value="hi123456"> <br>
		<input type="submit" value="로그인">
	</form>

	<a href="jLogout.do">로그아웃</a>
</body>
</html>