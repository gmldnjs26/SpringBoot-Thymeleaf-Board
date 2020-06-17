package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.CommentVO;
import com.board.mapper.CommentMapper;

@Service
public class CommentService {
	@Autowired
	private CommentMapper commentMapper;

	public List<CommentVO> getCommentList(int b_code) {
		return commentMapper.getCommentList(b_code);
	}
	public void insert(CommentVO commentVO) {
		commentMapper.insert(commentVO);
	}
	public void delete(int c_code) {
		commentMapper.delete(c_code);
	}
	
	
}
