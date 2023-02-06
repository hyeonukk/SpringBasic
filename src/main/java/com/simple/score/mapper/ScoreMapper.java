package com.simple.score.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.command.ScoreVO;

@Mapper //mybatis-scan
public interface ScoreMapper {

	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getList();
	public void delete(int num);
}
