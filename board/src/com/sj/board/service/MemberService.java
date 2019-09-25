package com.sj.board.service;

import java.util.ArrayList;

import com.sj.board.domain.MemberVO;

public interface MemberService {
	/* 회원가입 */
	public void addMember(String m_id, String m_pw, String m_name);
	
	/* 로그인 */
	public MemberVO getMember(String inputId);
	
	/* 게시글 작성자 이름 불러오기 */
	public String getM_name(String m_code);

	/* 회원 목록 불러오기 */
	public ArrayList<MemberVO> getMemberList();
}
