/**
 * 
 */
$(document).ready(function(){
	var tbody = $("tbody");
	
	/* 게시글 로드*/
	$.ajax({
		type: "POST",
		url: "/board",
//		data: {},
		dataType: "json", // 서버로부터 반환되는 데이터 형식
		success: function(result) { // 서버로부터 반환되는 데이터(result) = 게시글 목록
			console.log(result);
			for(var i=0; i<result.length; i++) { // 게시글 수만큼 반복
				var tr = $("<tr></tr>"); // <tr>태그를 새로 만들고, 변수 tr에 저장
				var inputTag = $("<input/>"); // <input>태그를 새로 만들고 변수 inputTag에 저장
				
				// <td>태그를 <tr>태그 안에 순서대로 추가한 후
				// <td>태그 안에 <a>태그와 각 컬럼 값(result)을 추가
				$("<td style='text-align:center;'></td>").html(result.length-i).appendTo(tr);
				$("<td style='text-align:center;'></td>").html("<a href='/board/post?" + result[i].p_code + "' class='aTag'>" + result[i].p_title + "</a>").appendTo(tr);
				$("<td style='text-align:center;'></td>").html(result[i].m_name).appendTo(tr);
				$("<td style='text-align:center;'></td>").html(result[i].p_reg).appendTo(tr);
				$("<td style='text-align:center;'></td>").html(result[i].p_read).appendTo(tr);
				$("<td style='text-align:center;'></td>").html(result[i].p_rec1).appendTo(tr);
				$("<td style='text-align:center;'></td>").html(result[i].p_rec2).appendTo(tr);
				$("<input type='hidden'/>").html(result[i].p_code).appendTo(tr);
				
				// <input>태그의 속성으로 type="hidden"와 value="게시글 코드"를 추가
				$(inputTag).attr("type", "hidden");
				$(inputTag).attr("value", result[i].p_code);
				
				// <input>태그의 class 속성을 p_code로 지정(게시글 조회 시 사용)
				$(inputTag).addClass("p_code");
				
				// <input>태그를 <tr>태그 안에 추가
				inputTag.appendTo(tr); 
				
				// <tr>태그를 <tbody>태그 안에 추가
				tr.appendTo(tbody);
			}
		},
		error: function(error) {
			console.log(error);
			alert("오류가 발생하였습니다.");
		}
	});
	
	/* 게시글 작성 */
	$("#writePost").click(function(){
		$.ajax({
			type: "POST",
			url: "/board/writePost",
//			data: {}, // 게시판이 여러 개일 경우, 게시판 코드를 보내 처리하면..
			dataType: "json", // 서버로부터 반환되는 데이터 형식
			success: function(result) { // 서버로부터 반환되는 데이터(result) = 게시글 작성 폼 URI
				console.log(result);
				window.location.href = result.URI; // window.location.href = "/board/postForm"
			},
			error: function(error) {
				console.log(error);
				alert("오류가 발생하였습니다.");
			}
		});
	});
	
	/* 게시글 조회 */
	// "동적"으로 생성된 태그에 대한 이벤트 적용
	// $(document).on("이벤트명", "이벤트", 함수명(){함수내용});
//	$(document).on("click", ".aTag", function(){
//		var p_code;
//		console.log(p_code);
//		window.location.href = "/board/post?" + p_code; // 쿼리스트링
//	});
	
//	/* 게시글 조회 */
//	// "동적"으로 생성된 태그에 대한 이벤트 적용
//	// $(document).on("이벤트명", "이벤트", 함수명(){함수내용});
//	$(document).on("click", ".aTag", function(){
//		var p_code = $(".p_code").val(); // 게시글 코드
//		
//		var data = { p_code: p_code };
//			
//		$.ajax({
//			type: "POST",
//			url: "/board/openPost",
//			data: {},
//			dataType: "json", // 서버로부터 반환되는 데이터 형식
//			success: function(result) { // 서버로부터 반환되는 데이터(result) = 게시글 작성 폼 URI
//				console.log(result);
//				window.location.href = result.URI; // window.location.href = "/board/post"
//			},
//			error: function(error) {
//				console.log(error);
//				alert("오류가 발생하였습니다.");
//			}
//		});
//	});
});