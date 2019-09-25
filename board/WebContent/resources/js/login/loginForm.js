/**
 * 
 */
$(document).ready(function(){
	/* 로그인 */
	$("#login").click(function(){ // 로그인 버튼 클릭 시
		var m_id = $("#m_id").val(); // 사용자가 입력한 아이디
		var m_pw = $("#m_pw").val(); // 사용자가 입력한 비밀번호
		
		var data = { // 서버로 보낼 데이터
				m_id: m_id,
				m_pw: m_pw
		}
		
		$.ajax({
			type: "POST",
			url: "/login",
			contentType: "application/json", // 서버로 보낼 데이터 형식
			data: JSON.stringify(data), // 서버로 보낼 데이터를 JSON으로 변환
			dataType: "json", // 서버로부터 반환되는 데이터 형식
			success: function(result) { // 서버로부터 반환되는 데이터(result)
				console.log(result);
				switch(result.status) {
				case -1:
					alert("존재하지 않는 아이디입니다.");
					break;
				case 0:
					alert("비밀번호가 일치하지 않습니다.");
					break;
				case 1:
					window.location.href = "/board";
					break;
				case 2:
					alert("알 수 없는 오류가 발생하였습니다.");
					break;
				}
			},
			error: function(error) {
				console.log(error);
				alert("오류가 발생하였습니다.");
			}
		});
	});
});