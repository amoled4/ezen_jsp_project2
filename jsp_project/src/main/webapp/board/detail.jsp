<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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


	<!-- 댓글작성라인 -->
	<div class="commentWrite">
		<input type="text" id="cmtWriter" value="${ses.id }"
			readonly="readonly"><br>
		<textarea rows="5" cols="70" placeholder="댓글을 등록해 주세요." id="cmtText"></textarea>
		<button type="button" id="cmtAddBtn">등록</button>
	</div>
	<!-- 댓글표시라인 -->
	<div id="commentBox">
		<strong>writer</strong> <br>
		<textarea rows="3" cols="3" class="form-control" id="cmtText1">${result[i].content}</textarea>
		<button type="button" data-cno="${result[i].cno}"
			data-writer="${result[i].writer}" class="btn cmtModBtn">수정</button>
		<button type="button" data-cno="${result[i].cno}"
			data-writer="${result[i].writer}" class="btn cmtDelBtn">삭제</button>
	</div>

	<script type="text/javascript">
		const bnoVal = `<c:out value="${bvo.bno}"/>`;
	</script>
	<script type="text/javascript" src="/resources/board_detail.js">
		
	</script>
	<script type="text/javascript">
		printCommentList(bnoVal);
	</script>
</body>
</html>