package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.BoardVO;
import com.board.mapper.BoardMapper;

import utils.CriteriaVO;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardVO>getAllBoradList() {
		return boardMapper.getAllBoardList();
	}
	public List<BoardVO>getPagingBoardList(CriteriaVO cri) {
		return boardMapper.getPagingBoardList(cri);
	}
	

	public void save(BoardVO boardVO) {
		boardMapper.save(boardVO);
		
	}

	public void delete(int b_code) {
		boardMapper.delete(b_code);
	}

	public BoardVO findOne(int b_code) {
		return boardMapper.findOne(b_code);
	}

	public int getTotalRecord() {
		return boardMapper.getTotalRecord();
	}
}
