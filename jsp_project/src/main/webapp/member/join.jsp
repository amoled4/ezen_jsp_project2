<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.box {
	width: 500px;
	height: 600px;
	background-color: #989898;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	border-radius: 10px;
}
h1{
	margin-top: 100px;
}
table{
	margin: 90px;
}

button {
	padding: 5px 15px;
	border: none;
}
</style>
</head>
<body>
<div class="box">
	<h1>회원가입 페이지</h1>
	<form action="/mem/register" method="post"> 
		<table>
			<tr>
				<th>*아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>*비밀번호</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<th>*이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" placeholder="숫자만 입력"></td>
			</tr>
			<tr>
				<th>*이메일</th>
				<td><input type="email" name="email"></td>
			</tr>
		</table>
		<br>
		<strong>* 표시는 필수 입력입니다.</strong> <br><br>
		<button type="submit">가입 완료</button>
	</form>
	</div>
</body>
</html>