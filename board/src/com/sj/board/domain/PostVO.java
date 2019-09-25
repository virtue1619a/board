package com.sj.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PostVO {
	private String p_code; // 게시글 코드
	private String p_title; // 게시글 제목
	private String p_content; // 게시글 내용
	private Date p_reg; // 게시글 작성일
	private String m_code; // 게시글 작성자
	private int p_read; // 조회수
	private int p_rec1; // 일반 추천수
	private int p_rec2; // 전문가 추천수
}
