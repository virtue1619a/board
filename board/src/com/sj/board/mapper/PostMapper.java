package com.sj.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.sj.board.domain.PostVO;

public interface PostMapper {
	/* 게시글 로드 */
	public ArrayList<PostVO> getPostList();

	/* 게시글 등록 */
	public int addPost(@Param("p_title") String p_title, @Param("p_content") String p_content, @Param("m_code") String m_code);

	/* 게시글 조회 */
	public PostVO getPostDetail(String queryString);
	
	/* 게시글 삭제 */
	public void delPost(String p_code);

	public int getRec1(String p_code);
	
	public int plusRec1(@Param("p_code") String p_code, @Param("p_rec1") int p_rec1);

	public int getRec2(String p_code);

	public int plusRec2(@Param("p_code") String p_code, @Param("p_rec2") int p_rec2);
}
