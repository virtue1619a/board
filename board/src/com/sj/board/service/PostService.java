package com.sj.board.service;

import java.util.ArrayList;

import com.sj.board.domain.PostVO;

public interface PostService {
	/* 게시글 로드 */
	public ArrayList<PostVO> getPostList();
	
	/* 게시글 등록 */
	public int addPost(String p_title, String p_content, String m_code);

	/* 게시글 조회 */
	public PostVO getPostDetail(String queryString);

	public int getRec1(String p_code);
	
	public int plusRec1(String p_code, int p_rec1);

	public int getRec2(String p_code);

	public int plusRec2(String p_code, int p_rec2);

	public void delPost(String p_code);
}
