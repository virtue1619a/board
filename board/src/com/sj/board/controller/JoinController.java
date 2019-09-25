package com.sj.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sj.board.domain.MemberVO;
import com.sj.board.service.MemberService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONObject;

/* 회원가입 컨트롤러 */
@Controller
@AllArgsConstructor
@RequestMapping(value = "/join")
public class JoinController {
	private MemberService memberService;
	
	/* 회원가입 폼 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String join() {
		return "join/joinForm";
	}

	/* 회원가입 */
	@ResponseBody
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public JSONObject addMember(@RequestBody MemberVO input) {
		// vo에 저장된 각 값을 m_id, m_pw, m_name에 저장
		String m_id = input.getM_id();
		String m_pw = input.getM_pw();
		String m_name = input.getM_name();
		
		// insert into member values(m_code, m_id, m_pw, m_name, m_reg);
		memberService.addMember(m_id, m_pw, m_name);
		
		// 클라이언트에 보낼 데이터를 담기 위한 Map
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		
		// Map을 JSONObject로 변환
		JSONObject result = JSONObject.fromObject(map);
		
		return result;
	}
}
