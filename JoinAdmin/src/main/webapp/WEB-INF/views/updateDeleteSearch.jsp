<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ִ��� �˻��ϼ���</title>
</head>
<body>
<jsp:include page = "startMenu.jsp" />
	<hr/>
<form class="navbar-form navbar-left" action = "searchForm" method = "post">
  <div class="form-group" style=margin-left:100px>
    <input type="text" class="form-control" placeholder="���̵�� �˻��ϼ���." name = "search_desc">
  </div>
  <button type="submit" class="btn btn-default">�˻�</button>
  <input type="hidden" name = "cmd" value = "${ cmd }"/> 
</form>
</body>
</html>