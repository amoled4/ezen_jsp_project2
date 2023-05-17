<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정 페이지</title>
</head>
<body>
	<h1>글수정 페이지</h1>
	<form action="/brd/edit">
	<table>
		<tr>
			<th>글번호</th>
			<td><input type="text" name="bno" readonly="readonly" value="${bvo.bno }"></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title" value="${bvo.title }"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" readonly="readonly" value="${bvo.writer }"></td>
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
			<td><textarea rows="3" cols="30" name="content">${bvo.content }</textarea></td>
		</tr>
	</table>
	<button type="submit">수정완료</button>
	</form>
	<a href="/brd/remove?bno=${bvo.bno }"><button type="button">삭제</button></a>
	<a href="/brd/list"><button type="button">취소</button></a>
</body>
</html>