<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
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
	font-style: italic;
	font-size: 50px;
}
button {
	margin: 40px 5px;
	padding: 5px 15px;
	border: none;

}
</style>
</head>
<body>
	<div class="box">
		<h1>Welcome to JSP</h1>


		<c:if test="${ses.mid ne null }">
		${ses.mname } 님이 로그인하였습니다. <br>
		계정 생성일 : ${ses.regdate } <br>
		마지막 접속 : ${ses.last_login } <br>
			<a href="/mem/modify"><button>회원정보수정</button></a>
			<a href="/mem/logout"><button>로그아웃</button></a>
			<a href="/brd/list"><button>게시판</button></a>
		</c:if>


		<c:if test="${ses.mid eq null }">
			<a href="/mem/join"><button>회원가입</button></a>
			<a href="/mem/login"><button>로그인</button></a>
		</c:if>

		<c:if test="${ses.mgrant eq '1' }">
			<a href="/mem/list"><button>관리자 페이지</button></a>
		</c:if>
	</div>
	<script type="text/javascript">
	const msg_login = `<c:out value="${msg_login}" />`;
	console.log(msg_login);
	if(msg_login === '0'){
		alert('로그인 정보가 올바르지 않습니다.');
		
	const msg_delete = `<c:out value="${msg_delete}" />`;
	if(msg_delete === '0'){
		alert('회원탈퇴가 정상적으로 이뤄지지 않았습니다.');
	}
	
	const msg_edit = `<c:out value="${msg_edit}" />`;
	if(msg_edit === '0'){
		alert('권한이 없습니다.'")};
	}
</script>
</body>
</html>