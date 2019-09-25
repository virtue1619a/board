<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/resources/js/board/member.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>회원코드</td>
			<td>아이디</td>
			<td>이름</td>
			<td>가입일</td>
			<td>전문가여부</td>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.m_code}</td>
				<td>${member.m_id}</td>
				<td>${member.m_name}</td>
				<td>${member.m_reg}</td>
				<td>${member.m_type}</td>
			</tr>
		</c:forEach>
		</table>
		
</body>
</html>