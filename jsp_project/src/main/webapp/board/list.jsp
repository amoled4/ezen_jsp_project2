<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록 페이지</title>
<style type="text/css">
	table, tr, th, td{
		text-align: center;
		border-top: 1px solid black;
		border-bottom: 1px solid black;
		border-collapse: collapse;
		padding: 10px 0;
		width: 800px;
		
	}
	button{
	}
</style>
</head>
<body>
	<h1>글목록 페이지</h1>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="bvo">
			<tr>
				<td>${bvo.bno }</td>
				<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
				<td>${bvo.writer }</td>
				<td>${bvo.regdate }</td>
				<td>${bvo.readcount }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/brd/register"><button type="button">글작성</button></a>
	<a href="/"><button type="button">메인으로</button></a>
</body>
</html>