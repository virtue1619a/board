/**
 * 
 */
$(document).ready(function(){
	$("#rec").click(function(){
		var p_code = $("#p_code").val();
		
		var data = {
				p_code: p_code
		};
		
		$.ajax({
			type: "POST",
			url: "/board/plusRec",
			contentType: "application/json", // 서버에 보낼 데이터 형식
			data: JSON.stringify(data), // 서버에 보낼 데이터를 JSON으로 변환
			dataType: "json", // 서버로부터 반환되는 데이터 형식
			success: function(result) { // 서버로부터 반환되는 데이터(result)
				console.log(result);
			},
			error: function(error) {
				console.log(error);
				alert("오류가 발생하였습니다.");
			}
		});
	});
	
	$("#delPost").click(function(){
		var p_code = $("#p_code").val();
		var m_code = $("#m_code").val();
		
		var data = {
				p_code: p_code,
				m_code: m_code
		};
		
		$.ajax({
			type: "POST",
			url: "/board/delPost",
			contentType: "application/json", // 서버에 보낼 데이터 형식
			data: JSON.stringify(data), // 서버에 보낼 데이터를 JSON으로 변환
			dataType: "json", // 서버로부터 반환되는 데이터 형식
			success: function(result) { // 서버로부터 반환되는 데이터(result)
				console.log(result);
				if(result.status==1){
				alert("삭제되었습니다.");
				window.location.href = "/board";
				}
				else{
					alert("본인의 게시글만 삭제할 수 있습니다.");
				}
			},
			error: function(error) {
				console.log(error);
			}
		});
	});
});