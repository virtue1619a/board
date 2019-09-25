<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/resources/js/board/board.js"></script>
</head>
<body>
	<div style="width:1200px;">
		<table style="width:1200px;">
			<thead>
				<tr>
					<td style="width:10%; text-align:center;">번호</td>
					<td style="width:30%; text-align:center;">제목</td>
					<td style="width:10%; text-align:center;">작성자</td>
					<td style="width:20%; text-align:center;">등록일</td>
					<td style="width:10%; text-align:center;">조회수</td>
					<td style="width:10%; text-align:center;">일반추천수</td>
					<td style="width:10%; text-align:center;">전문가추천수</td>
				</tr>
			</thead>
			<tbody>
				<!-- 게시글 목록 -->
			</tbody>
		</table>
		<div style="text-align:right;">
			<button id="writePost">작성</button>
			<a href="/login">로그인</a>
		</div>
	</div>
</body>
</html>