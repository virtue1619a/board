package com.sj.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//
public class BoardInterceptor extends HandlerInterceptorAdapter {
	// preHandle(): 컨트롤러보다 먼저 실행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(); // 세션 객체
		Object obj = session.getAttribute("memberInfo"); // 로그인된 회원 정보가 저장된 세션 객체
		
		if(obj==null) { // 비로그인		
			// 로그인 페이지로 이동
			response.sendRedirect("/login"); 
			
			// 더 이상 BoradController로 가지 않도록 false를 반환
			return false; 
		}
		
		// preHandle() 메소드의 return은
		// 컨트롤러에 작성된 요청 URI로 이동하는 것에 대한 허가 여부를 의미
		return true;
	}
}
