<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="/mem/register" method="post"> 
		*아이디 : <input type="text" name="id"> <br>
		*비밀번호 : <input type="password" name="pw"> <br>
		*이름 : <input type="text" name="name"> <br>
		전화번호 : <input type="text" name="phone" placeholder="숫자만 입력"> <br>
		*이메일 : <input type="email" name="email"> <br>
		<br>
		<strong>* 표시는 필수 입력입니다.</strong> <br><br>
		<button type="submit">가입 완료</button>
	</form>
</body>
</html>