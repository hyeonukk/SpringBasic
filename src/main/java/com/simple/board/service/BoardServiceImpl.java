package com.simple.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.board.mapper.BoardMapper;
import com.simple.command.BoardVO;

@Service("zzz")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void regist(BoardVO vo) {
		boardMapper.regist(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		return boardMapper.getList();
	}

}
