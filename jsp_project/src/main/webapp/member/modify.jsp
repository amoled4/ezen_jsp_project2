<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 페이지</title>
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
	margin-top: 70px;
}
table{
	margin: 70px;
}

button {
	padding: 5px 15px;
	border: none;
	margin-bottom: 10px;
}
</style>
</head>
<body>
<!-- 아이디
비밀번호(수정)
이름
전화번호(수정)
이메일(수정)
가입날짜
last_login
수정완료 버튼=> index로 이동
회원탈퇴버튼  => 정보를 controller로 이동-> 로그아웃 진행 -> DB delete -> index.jsp
메인버튼
 -->
 <div class="box">
	<h1>회원정보 수정</h1>
	<form action="/mem/edit" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" readonly="readonly" name="id" value="${mvo.mid }"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="pw"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" readonly="readonly" name="name" value="${mvo.mname }"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<th>가입날짜</th>
			<td><input type="text" readonly="readonly" name="regdate" value="${mvo.regdate }"></td>
		</tr>
		<tr>
			<th>마지막 로그인 시간</th>
			<td><input type="text" readonly="readonly" name="last_login" value="${mvo.last_login }"></td>
		</tr>
	</table>
	
	<button type="submit">수정완료</button>
	</form>
	<a href="/mem/delete?mid=${mvo.mid }"><button type="button">회원탈퇴</button></a>
	<a href="/"><button type="button">취소</button></a>
</div>	
</body>
</html>