<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("onload");
	});
</script>
</head>
<body>
	<h1>관리자 정보 insert.jsp</h1>

	<jsp:include page="../top_menu.jsp"></jsp:include>

	<!-- 안적으면 get 방식(기본) -->
	<form action="insertOK.do" method="post" enctype="multipart/form-data">

		<table border="1">
			<tr>
				<th>attraction</th>
				<td><input type="text" name="attraction" value="대관령"></td>
			</tr>
			<tr>
				<th>location</th>
				<td><input type="text" name="location" value="강원도"></td>
			</tr>
			<tr>
				<th>content</th>
				<td><textarea rows="10" cols="30" name="content">눈이 많이 온다</textarea></td>
			</tr>
			<tr>
				<th>tdate</th>
				<td>날짜<br>
				 <input type='checkbox' name='tdate' value='1월' >1월 
				<input type='checkbox' name='tdate' value='2월' >2월
				<input type='checkbox' name='tdate' value='3월' >3월
				<input type='checkbox' name='tdate' value='4월' >4월
				<input type='checkbox' name='tdate' value='5월' >5월
				<input type='checkbox' name='tdate' value='6월' >6월
				<br>
				<input type='checkbox' name='tdate' value='7월' >7월
				<input type='checkbox' name='tdate' value='8월' >8월
				<input type='checkbox' name='tdate' value='9월' >9월
				<input type='checkbox' name='tdate' value='10월' >10월
				<input type='checkbox' name='tdate' value='11월' >11월
				<input type='checkbox' name='tdate' value='12월' >12월
				</td>
			</tr>
			<tr>
				<th>image</th>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>

	</form>
</body>
</html>