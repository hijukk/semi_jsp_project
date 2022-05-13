<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mySelectAll</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("onload");
	});
</script>
</head>
<body>
	<h1>mySelectAll</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>

	<table border="1">
		<tr>
			<th>attraction</th>
			<th>id</th>
			<th>save_date</th>
		</tr>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td><a href="mySelectOne.do?attraction=${vo.attraction}">${vo.attraction}</a></td>
				<td>${vo.id}</td>
				<td>${vo.save_date}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>