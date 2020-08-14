<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>jsp 게시판 웹사이트</title>
</head>
<body>
	<jsp:include page = "navi.jsp" />
	<!-- 게시판 -->
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">내용</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
						<th style="background-color: #eeeeee; text-align: center;">기능</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ empty list }">
						<tr>
							<td colspan = "6">등록된 게시글이 없습니다.</td>
						</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var ="board" items = "${ list }">
								<tr>
									<td>${ board.b_id }</td>
									<td>${ board.b_title }</td>
									<td>${ board.b_content }</td>
									<td>${ board.b_date } </td>
									<td><a href = "boardUpdate?cmd=${board.b_id}" class = "btn btn-warning">수정</a>
										<a href = "boardDelete?cmd=${board.b_id}" class = "btn btn-danger">삭제</a></td>
								<tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<a href="goWrite" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>
