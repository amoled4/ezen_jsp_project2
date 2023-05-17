<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 페이지</title>
</head>
<body>
	<h1>게시글 보기</h1>
	<table>
		<tr>
			<th>글번호</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td>${bvo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${bvo.regdate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bvo.readcount }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${bvo.content }</td>
		</tr>
	</table>
	<c:if test="${bvo.writer eq ses.mid}">
	<a href="/brd/modify?bno=${bvo.bno }"><button type="button">수정</button></a>
	<a href="/brd/remove?bno=${bvo.bno }"><button type="button">삭제</button></a>
	</c:if>
	<a href="/brd/list"><button type="button">뒤로가기</button></a>
</body>
</html>