package com.sj.board.pagination;

import lombok.Data;

@Data
public class Pagination {
	private int pageSize = 10; // 페이지당 게시글 수
	private int blockSize = 10; // 블록당 페이지 수
	private int curPage = 1; // 현재 페이지
	private int curBlock = 1; // 현재 블록
	private int totalPost; // 총 게시글 수
	private int totalPage; // 총 페이지 수
	private int totalBlock; // 총 블록 수
	private int startPage = 1; // 시작 페이지
	private int endPage = 1; // 끝 페이지
	private int startIndex = 0; // 시작 인덱스
	private int prevPage; // 이전 페이지
	private int nextPage; //다음 페이지	
}
