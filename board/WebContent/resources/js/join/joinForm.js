/**
 * 
 */
$(document).ready(function(){
	/* 회원가입 */
	$("#join").click(function(){ // 로그인 버튼 클릭 시
		var m_id = $("#m_id").val(); // 사용자가 입력한 아이디
		var m_pw = $("#m_pw").val(); // 사용자가 입력한 비밀번호
		var m_name = $("#m_name").val(); // 사용자가 입력한 이름
		
		var data = { // 서버로 보낼 데이터
				m_id: m_id,
				m_pw: m_pw,
				m_name: m_name
		}
		
		$.ajax({
			type: "POST",
			url: "/join/addMember",
			contentType: "application/json", // 서버에 보낼 데이터 형식
			data: JSON.stringify(data), // 서버에 보낼 데이터를 JSON으로 변환
			dataType: "json", // 서버로부터 반환되는 데이터 형식
			success: function(result) { // 서버로부터 반환되는 데이터(result)
				console.log(result);
				alert(result);
				window.location.href = "/"; // 홈으로 이동
			},
			error: function(error) {
				console.log(error);
				alert("오류가 발생하였습니다.");
			}
		});
	});
});