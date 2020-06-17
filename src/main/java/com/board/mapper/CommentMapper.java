package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.dto.CommentVO;

@Mapper
public interface CommentMapper {
	List<CommentVO> getCommentList(int b_code);
	void insert(CommentVO commentVO);
	void delete(int c_code);
}
