<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ��������</title>
</head>
<body>
<jsp:include page = "searchForm.jsp" />
<hr/>
<table class="table">
  <thead>
    <tr>
      <th scope="col">���̵�</th>
      <th scope="col">�̸�</th>
      <th scope="col">�г���</th>
      <th scope="col">��ȭ��ȣ</th>
    </tr>
  </thead>
  <tfoot>
  	<c:choose>
  		<c:when test="${ empty list }">
  			<th scope ="row" colspan = "4"> [0]��rows </th>
  		</c:when>
		<c:otherwise>
	  		<th scope ="row" colspan = "4"> [ 0 ]��rows </th>
	  	</c:otherwise>	
  	</c:choose>
  </tfoot>
  <tbody>
	<c:choose>
		<c:when test="${ empty list }">
    		 <tr>
    			<th scope="row">��ϵ� ������ �����ϴ�.</th>
    		</tr>
    	</c:when>  
    	<c:otherwise> 
    		<c:forEach var = "list" items ="${ list }">
	    		<tr>
					<td scope = "row"> ${ list.id } </td>
					<td scope = "row"> ${ list.name }</td>
					<td scope = "row"> ${ list.nickName }</td>
					<td scope = "row"> ${ list.tel }</td>
				</tr>
			</c:forEach>	 	
	 	</c:otherwise>
	 </c:choose>    
  </tbody>
</table>
</body>
</html>