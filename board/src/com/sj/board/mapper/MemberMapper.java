package com.sj.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.sj.board.domain.MemberVO;

public interface MemberMapper {
	/* 회원가입 */
	public void addMember(@Param("m_id") String m_id, @Param("m_pw") String m_pw, @Param("m_name") String m_name);

	/* 로그인 */
	public MemberVO getMember(String inputId);

	/* 게시글 작성자 불러오기 */
	public String getM_name(String m_code);

	/* 회원 목록 불러오기 */
	public ArrayList<MemberVO> getMemberList();
}
