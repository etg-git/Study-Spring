<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>jsp 게시판</title>
</head>
<body>
	<jsp:include page = "navi.jsp" />
	<div class="container">
		<div class="row">
			<form action="boardWrite" method = "post">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">게시판
								글쓰세요</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="글 제목" name="b_title" maxlength="50"/></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" name="b_content" maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>	
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기" />
			</form>
		</div>
	</div>
</body>
</html>
