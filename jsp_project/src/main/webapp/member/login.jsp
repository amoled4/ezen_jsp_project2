<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
	.box {
	width: 500px;
	height: 300px;
	background-color: #989898;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	border-radius: 10px;
}
h1{
	margin-top: 40px;
}
table{
	margin: 40px 100px;	
}
button {
	margin-top: 10px;
	padding: 5px 15px;
	border: none;
}
</style>
</head>
<body>
	<div class="box">
	<h1>로그인 페이지</h1>
	<form action="/mem/login_auth" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"></td>
			</tr>
		</table>
		<button type="submit">로그인</button>
	</form>
	</div>
</body>
</html>