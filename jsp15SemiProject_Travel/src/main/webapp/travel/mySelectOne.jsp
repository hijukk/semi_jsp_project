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
	<h1>myselectOne</h1>
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
			<td><input type="hidden" name="attraction" value="${vo2.attraction}"> ${vo2.attraction}</td>
			<td><input type="hidden" name="location" value="${vo2.location}">${vo2.location}</td>
			<td><input type="hidden" name="content" value="${vo2.content}">${vo2.content}</td>
			<td><input type="hidden" name="tdate" value="${vo2.tdate}">${vo2.tdate}</td>
			<td><input type="hidden" name="file" value="${vo2.save_file_name}"><img width="50px" src="uploadimg/${vo2.save_file_name}"></td>
		</tr>
	</table>
	<a href="myDelete.do?attraction=${vo2.attraction}">찜삭제</a>


</body>
</html>