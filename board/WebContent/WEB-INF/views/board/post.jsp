<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/resources/js/board/post.js"></script>
</head>
<body>
	<input type="hidden" id="p_code" value="${post.p_code}"/>
	<input type="hidden" id="m_code" value="${post.m_code}"/>
	<table style="width:500px;">
		<tr>
			<td style="width:15%; text-align:right;">제목</td>
			<td style="width:85%;">${post.p_title}</td>
		</tr>
		<tr>
			<td style="text-align:right;">내용</td>
			<td>${post.p_content}</td>
		</tr>
		<tr>
			<td style="text-align:right;">작성자</td>
			<td>${m_name}</td>
			
		</tr>
		<tr>
			<td style="text-align:right;">작성일</td>
			<td>${p_reg}</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right;">
				<button id="rec">추천</button>
				<button id="delPost">삭제</button>
				<a href="/board">목록으로</a>
			</td>
		</tr>
	</table>
	
</body>
</html>