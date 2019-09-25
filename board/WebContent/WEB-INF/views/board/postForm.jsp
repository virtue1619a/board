<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/resources/js/board/postForm.js"></script>
</head>
<body>
	<div style="width:306px;">
		<input type="text" id="p_title" style="width:302px;"/><br/>
		<textarea id="p_content" style="width:300px; height:200px;"></textarea><br/>
		<div style="text-align:right">
			<button id="addPost">등록</button>
		</div>
	</div>
</body>
</html>