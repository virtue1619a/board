<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/resources/js/login/loginForm.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="m_id"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="m_pw"/></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button id="login" style="width:100%;">로그인</button>
			</td>
		</tr>
	</table>
</body>
</html>