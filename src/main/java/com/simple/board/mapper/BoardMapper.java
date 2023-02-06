package com.simple.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.command.BoardVO;

@Mapper
public interface BoardMapper {

	public void regist(BoardVO vo);
	public ArrayList<BoardVO> getList();
}
