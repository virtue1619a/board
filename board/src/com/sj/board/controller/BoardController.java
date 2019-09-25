package com.sj.board.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sj.board.domain.MemberVO;
import com.sj.board.domain.PostVO;
import com.sj.board.service.MemberService;
import com.sj.board.service.PostService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/* 게시판 컨트롤러 */
@Controller
@AllArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {
	private PostService postService;
	private MemberService memberService;
	
	/* 게시판 뷰 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String board() {
		return "board/board";
	}
	
	/* 게시글 로드 */
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public JSONArray loadPost() {
		ArrayList<PostVO> postList = new ArrayList<>(); // 게시판에 있는 게시글 쿼리 결과를 저장할 ArrayList
		postList = postService.getPostList(); // 쿼리 결과를 저장
		
		JSONArray jPostList = new JSONArray(); // 각 게시글에 대한 컬럼 정보를 저장할 JSONArray
		
		for(int i=0; i<postList.size(); i++) { // 쿼리 결과의 게시글 수만큼 반복
			Map<String, Object> map = new HashMap<>(); // 하나의 게시글에 대한 컬럼 정보를 저장할 Map
			map.put("p_code", postList.get(i).getP_code());
			map.put("p_title", postList.get(i).getP_title());
			
			String m_code = postList.get(i).getM_code(); // 게시글 작성자(회원코드)
			String m_name = memberService.getM_name(m_code); // 회원코드로 회원 이름 불러오기
			map.put("m_name", m_name);
			
			Date p_reg = postList.get(i).getP_reg();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd"); // 날짜 형식 지정
			map.put("p_reg", dateFormat.format(p_reg)); // 날짜 형식 변환
			
			map.put("p_read", postList.get(i).getP_read());
			map.put("p_rec1", postList.get(i).getP_rec1());
			map.put("p_rec2", postList.get(i).getP_rec2());
			
			// Map를 JSONObject 형식으로 변환하여 JSONObject에 저장
			JSONObject jObj = JSONObject.fromObject(map);
			
			// 하나의 게시글에 대한 컬럼 정보가 저장된 JSONObject를 JSONArray에 저장
			jPostList.add(jObj);
		}
		
		return jPostList;
	}
	
	/* 게시글 조회 */
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String post(HttpServletRequest request, Model model) {
		String queryString = request.getQueryString(); // 쿼리스트링
		
		// 게시글 정보를 저장할 PostVO
		PostVO post = new PostVO();
		post = postService.getPostDetail(queryString);
		
		// 게시글 정보의 m_code를 사용하여 m_name 불러오기
		String m_code = post.getM_code();
		String m_name = memberService.getM_name(m_code);
		
		Date p_reg = post.getP_reg();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm"); // 날짜 형식 지정
		
		model.addAttribute("post", post);
		model.addAttribute("m_name", m_name);
		model.addAttribute("p_reg", dateFormat.format(p_reg)); // 날짜 형식 변환
		
		return "board/post";
	}
	
	/* 게시글 작성 폼 */
	@RequestMapping(value = "/postForm", method = RequestMethod.GET)
	public String postForm() {
		return "board/postForm";
	}
	
	/* 게시글 작성(게시글 작성 폼으로 이동) */
	@ResponseBody
	@RequestMapping(value = "/writePost", method = RequestMethod.POST)
	public JSONObject writePost() {
		// 클라이언트에 보낼 데이터를 담기 위한 Map
		Map<String, String> map = new HashMap<>();
		map.put("URI", "/board/postForm"); // 게시글 작성 폼 URI
		
		// Map을 JSONObject로 변환
		JSONObject result = JSONObject.fromObject(map);
		
		return result;
	}
	
	/* 게시글 등록 */
	@ResponseBody
	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public JSONObject addPost(@RequestBody PostVO input, HttpServletRequest request) {
		// 세션에 저장된 회원 정보 불러오기
		HttpSession session = request.getSession();
		MemberVO memberInfo = (MemberVO)session.getAttribute("memberInfo");
		
		String m_code = memberInfo.getM_code(); // 회원 정보(회원 코드)
		String p_title = input.getP_title(); // input에 저장된 게시글 제목
		String p_content = input.getP_content(); // input에 저장된 게시글 내용
		
		// insert into member values(p_code, m_title, p_content, p_reg, m_code);
		// 반환되는 값은 결과 행의 수
		int status = postService.addPost(p_title, p_content, m_code);
		
		// 클라이언트에 보낼 데이터를 담기 위한 Map
		Map<String, Integer> map = new HashMap<>();
		map.put("status", status); // 1(성공)
		
		// Map을 JSONObject로 변환
		JSONObject result = JSONObject.fromObject(map);
				
		return result;
	}
	
	/* 게시글 수정 */
	@ResponseBody
	@RequestMapping(value = "/editPost", method = RequestMethod.POST)
	public JSONArray editPost() {
		return null;
	}
	
	/* 게시글 삭제 */
	@ResponseBody
	@RequestMapping(value = "/delPost", method = RequestMethod.POST)
	public JSONObject delPost(@RequestBody PostVO input, HttpServletRequest request) {
		int status = 0;
		
		String p_code = input.getP_code();
		String m_code = input.getM_code();
		
		// 세션에 저장된 회원 정보 불러오기
		HttpSession session = request.getSession();
		MemberVO memberInfo = (MemberVO)session.getAttribute("memberInfo");
		
		String curM_code = memberInfo.getM_code();
		
		if(curM_code.equals(m_code)) {
			postService.delPost(p_code);
			status = 1;
		}
		else {
			status = 0;
		}
		
		// 클라이언트에 보낼 데이터를 담기 위한 Map
		Map<String, Integer> map = new HashMap<>();
		map.put("status", status);
				
		// Map을 JSONObject로 변환
		JSONObject result = JSONObject.fromObject(map);
				
		return result;
	}
	
	/* 게시글 추천 */
	@ResponseBody
	@RequestMapping(value = "/plusRec", method = RequestMethod.POST)
	public JSONObject plusRec(@RequestBody PostVO input, HttpServletRequest request) {
		int status = 0;
		
		String p_code = input.getP_code();
		
		// 세션에 저장된 회원 정보 불러오기
		HttpSession session = request.getSession();
		MemberVO memberInfo = (MemberVO)session.getAttribute("memberInfo");
		
		int m_type = memberInfo.getM_type(); // 전문가여부
		
		if(m_type==0) {
			int curP_rec1 = postService.getRec1(p_code);
			int p_rec1 = curP_rec1 + 1;
			status = postService.plusRec1(p_code, p_rec1);
		}
		else if(m_type==1) {
			int curP_rec2 = postService.getRec2(p_code);
			int p_rec2 = curP_rec2 + 1;
			status = postService.plusRec2(p_code, p_rec2);
		}
		
		// 클라이언트에 보낼 데이터를 담기 위한 Map
		Map<String, Integer> map = new HashMap<>();
		map.put("status", status);
				
		// Map을 JSONObject로 변환
		JSONObject result = JSONObject.fromObject(map);
				
		return result;
	}
}
