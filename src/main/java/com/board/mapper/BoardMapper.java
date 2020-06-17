package com.board.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.board.dto.BoardVO;

import utils.CriteriaVO;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getAllBoardList();

	public void save(BoardVO boardVO);
	public void delete(int b_code);
	public BoardVO findOne(int b_code);
	public int getTotalRecord();
	public List<BoardVO> getPagingBoardList(CriteriaVO cri);
	public void updateHit(int b_code);
}
