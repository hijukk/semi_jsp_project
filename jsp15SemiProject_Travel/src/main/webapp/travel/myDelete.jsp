<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("onload");
	});
</script>
</head>
<body>
	<h1>delete.jsp</h1>

	<jsp:include page="../top_menu.jsp"></jsp:include>

	<!-- 안적으면 get 방식(기본) -->
	<form action="myDeleteOK.do">

		<table border="1">
			<tr>
				<td>${param.attraction} 글을 찜 삭제하시겠습니까? 
				<input type="hidden" name="attraction" value="${param.attraction}"></td>
			</tr>
			<tr>
				<td><input type="submit" ></td>
			</tr>
		</table>

	</form>
</body>
</html>