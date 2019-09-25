package com.sj.board.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.sj.board.domain.MemberVO;
import com.sj.board.mapper.MemberMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImplement implements MemberService {
	private MemberMapper mapper;

	/* 회원가입 */
	@Override
	public void addMember(String m_id, String m_pw, String m_name) {
		mapper.addMember(m_id, m_pw, m_name);
	}
	
	/* 로그인 */
	@Override
	public MemberVO getMember(String inputId) {
		return mapper.getMember(inputId);
	}
	
	/* 게시글 작성자 이름 불러오기*/
	@Override
	public String getM_name(String m_code) {
		return mapper.getM_name(m_code);
	}

	/* 회원 목록 불러오기 */
	@Override
	public ArrayList<MemberVO> getMemberList() {
		return mapper.getMemberList();
	}
}
