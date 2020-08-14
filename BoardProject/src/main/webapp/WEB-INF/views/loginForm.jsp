<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="resources/css/loginStyle.css" />
<head>
	<title>�α����ϼ���</title>
</head>
<body>
<div class="inner_login">
    <div class="login_tistory">
        <form method="post" id="authForm" action="goBoard">
            <input type="hidden" name="redirectUrl" value="https://blogpack.tistory.com/manage">
            <fieldset>
            <h1> ${ msg } </h1>
            <legend class="screen_out">�α��� ���� �Է���</legend>
            <div class="box_login">
                <div class="inp_text">
                <label for="loginId" class="screen_out">���̵�</label>
                <input type="text" id="loginId" name="id" placeholder="ID" >
                </div>
                <div class="inp_text">
                <label for="loginPw" class="screen_out">��й�ȣ</label>
                <input type="password" id="loginPw" name="password" placeholder="Password" >
                </div>
            </div>
            <button type="submit" class="btn_login">�α���</button>
            <div class="login_append">
                <div class="inp_chk"> <!-- üũ�� checked �߰� -->
                <input type="checkbox" id="keepLogin" class="inp_radio"  name="keepLogin">
                <label for="keepLogin" class="lab_g">
        <span class="img_top ico_check"></span>
        <span class="txt_lab">�α��� ���� ����</span>
        </label>
                </div>
                <span class="txt_find">
                <a href="join" class="link_find">ȸ������</a>
                </span>
            </div>
            </fieldset>
        </form>
    </div>
</div>
 </body>
</html>
 