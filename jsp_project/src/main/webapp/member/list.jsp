<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<style type="text/css">
	table, tr, th, td{
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
		padding: 0 20px;
	}
</style>
</head>
<body>
	<h1>회원 목록</h1>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>이메일</th>
			<th>가입날짜</th>
		</tr>
		
		<c:forEach items="${list }" var="mvo">
			<tr>
			<td><a href="/mem/detail?mid=${mvo.mid }">${mvo.mid }</a></td>
			<td>${mvo.memail }</td>
			<td>${mvo.regdate }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>