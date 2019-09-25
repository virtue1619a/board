/**
 * 
 */
$(document).ready(function(){
	/* 게시글 등록 */
	$("#addPost").click(function(){
		var p_title = $("#p_title").val(); // 게시글 제목
		var p_content = $("#p_content").val(); // 게시글 내용
		
		var data = { // 서버로 보낼 데이터
				p_title: p_title,
				p_content: p_content
		}
		
		$.ajax({
			type: "POST",
			url: "/board/addPost",
			contentType: "application/json", // 서버에 보낼 데이터 형식
			data: JSON.stringify(data), // 서버에 보낼 데이터를 JSON으로 변환
			dataType: "json", // 서버로부터 반환되는 데이터 형식
			success: function(result) { // 서버로부터 반환되는 데이터(result) = 쿼리 결과의 행 수(1:정상)
				console.log(result);
				
				if(result.status == 1) { // 게시글 등록 성공
					window.location.href = "/board"; // 게시판으로 이동
					alert("게시글이 등록되었습니다.");
				}
				else { // 게시글 등록 실패
					alert("오류가 발생하였습니다.")
				}
			},
			error: function(error) {
				console.log(error);
				alert("오류가 발생하였습니다.");
			}
		});
	});
});