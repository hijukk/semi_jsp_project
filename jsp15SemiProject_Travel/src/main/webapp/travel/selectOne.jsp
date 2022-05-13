<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("onload");
	});
</script>
</head>
<body>
	<h1>selectOne</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<table border="1">
		<tr>
			<th>attraction</th>
			<th>location</th>
			<th>content</th>
			<th>tdate</th>
			<th>img</th>
		</tr>
		<tr>
			<td>${vo2.attraction}</td>
			<td>${vo2.location}</td>
			<td>${vo2.content}</td>
			<td>${vo2.tdate}</td>
			<td><img width="50px" src="uploadimg/${vo2.save_file_name}"></td>
		</tr>
	</table>
	<a href="myInsertOK.do?attraction=${vo2.attraction}">찜</a>
	<a href="update.do?attraction=${vo2.attraction}">수정</a>
	<a href="delete.do?attraction=${vo2.attraction}">삭제</a>
</body>
</html>