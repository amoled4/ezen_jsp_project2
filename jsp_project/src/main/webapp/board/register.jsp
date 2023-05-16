<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
</head>
<body>
	<h1>게시글 작성 페이지</h1>
	<form action="/brd/insert" method="post">
	글제목 : <input type="text" name="title"> <br>
	작성자 : <input type="text" name="writer" value="${ses.mid }" readonly="readonly"> <br>
	글내용 : <textarea rows="3" cols="30" name="content"></textarea> <br>
	
	<button type="submit">등록</button>
	</form>
	<a href="/"><button>취소</button></a>
</body>
</html>