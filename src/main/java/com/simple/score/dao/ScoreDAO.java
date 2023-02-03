package com.simple.score.dao;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreDAO {
	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getList();
	public void delete(int num);
}
