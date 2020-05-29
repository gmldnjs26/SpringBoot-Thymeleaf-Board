package com.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.board.dto.MemberVO;

@Mapper
public interface MemberMapper {
	public MemberVO getMember(String username);
	public void join(MemberVO memberVO);
}
