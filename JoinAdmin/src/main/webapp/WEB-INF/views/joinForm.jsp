<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<head>
	<title>����� Ȩ</title>
</head>
<body>
	
	<jsp:include page = "searchForm.jsp" />
	<hr/>
	<article class="container" style=margin-top:100px;>
          <div class="page-header">
              <div class="col-md-6 col-md-offset-3">
              <h3>ȸ������ Form</h3>
              </div>
          </div>
          <div class="col-sm-6 col-md-offset-3">
              <form action = "joinConfirm" method = "post">
              <input type = "hidden" name = "cmd" value = "insert"> 
                  <div class="form-group">
                      <label for="inputName">����</label>
                      <input type="text" class="form-control" name = "name" placeholder="�̸��� �Է��� �ּ���">
                  </div>
                  <div class="form-group">
                      <label for="inputPassword">��й�ȣ</label>
                      <input type="password" class="form-control"  name = "password" placeholder="��й�ȣ�� �Է����ּ���">
                  </div>
                  <div class="form-group">
                      <label for="inputNickname">�г���</label>
                      <input type="text" class="form-control" name = "nickName" placeholder="�г����� �Է� �� �ּ���">
                  </div>
                  <div class="form-group">
                      <label for="inputMobile">�޴��� ��ȣ</label>
                      <input type="text" class="form-control" name = "tel" placeholder="�޴�����ȣ�� �Է��� �ּ���">
                  </div>
                  <div class="form-group text-center">
                      <button type="submit"  class="btn btn-primary">
                          ȸ������<i class="fa fa-check spaceLeft"></i>
                      </button>
                  </div>
              </form>
          </div>
          </article>
</body>
</html>