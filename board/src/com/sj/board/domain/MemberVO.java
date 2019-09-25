package com.sj.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String m_code; // 회원 코드
	private String m_id; // 회원 아이디
	private String m_pw; // 회원 비밀번호
	private String m_name; // 회원 이름
	private Date m_reg; // 회원 가입일
	private int m_type; // 전문가유무
}
