<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<h1>Index Page</h1>
	
	
	<c:if test="${ses.mid ne null }">
		${ses.mid } 님이 로그인하였습니다. <br>
		계정 생성일 : ${ses.regdate } <br>
		마지막 접속 : ${ses.last_login } <br>
		<a href="/mem/modify"><button>회원정보수정</button></a>
		<a href="/mem/logout"><button>로그아웃</button></a>
	</c:if>
	
	
	<c:if test="${ses.mid eq null }">
	<a href="/mem/join"><button>회원가입</button></a>
		<a href="/mem/login"><button>로그인</button></a>
	</c:if>
	
	<c:if test="${ses.mgrant eq '1' }">
	<a href="/mem/list"><button>관리자 페이지</button></a>
	</c:if>
	
<script type="text/javascript">
	const msg_login = `<c:out value="${msg_login}" />`;
	console.log(msg_login);
	if(msg_login === '0'){
		alert('로그인 정보가 올바르지 않습니다.');
		
	const msg_delete = `<c:out value="${msg_delete}" />`;
	if(msg_delete === '0'){
		alert('회원탈퇴가 정상적으로 이뤄지지 않았습니다.');
	}
</script>
</body>
</html>