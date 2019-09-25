package com.sj.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sj.board.domain.MemberVO;
import com.sj.board.service.MemberService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONObject;

/* 로그인 컨트롤러 */
@Controller
@AllArgsConstructor
@RequestMapping(value = "/login")
public class LoginController {
	private MemberService memberService;
	
	/* 로그인 폼 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login() {
		return "login/loginForm";
	}
	
	/* 로그인 */
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public JSONObject login(@RequestBody MemberVO input, HttpServletRequest request) {
		// 사용자가 입력한 아이디와 비밀번호를 각각 inputId와 inputPw에 저장
		String inputId = input.getM_id();
		String inputPw = input.getM_pw();
		
		// 사용자가 입력한 아이디가 DB에 있는지
		MemberVO memberInfo = memberService.getMember(inputId);
		
		int status = 0; // -1(아이디 부재), 0(비밀번호 불일치), 1(로그인 성공), 2(알 수 없는 오류)
		
		if(memberInfo != null) {
			if(memberInfo.getM_pw().equals(inputPw)) {
				status = 1; // 로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("memberInfo", memberInfo); // 로그인된 회원 정보를 세션에 저장
			}
			else {
				status = 0; // 비밀번호 오류
			}
		}
		else {
			status = -1; // 아이디 부재
		}
		
		// 클라이언트에 보낼 데이터를 담기 위한 Map
		Map<String, Integer> map = new HashMap<>();
		map.put("status", status);
		
		// Map을 JSONObject로 변환
		JSONObject result = JSONObject.fromObject(map);
		
		return result;
	}
}
