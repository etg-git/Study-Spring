<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<jsp:include page = "startMenu.jsp" />
<form class="navbar-form navbar-left" action = "allSearch" method = "post">
	  <div class="form-group" style=margin-left:100px>
	    <input type="text" class="form-control" placeholder="���̵�� �˻��ϼ���." name = "search_desc">
	  </div>
	  <button type="submit" class="btn btn-default">�˻�</button>
</form>
</body>
</html>