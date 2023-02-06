package com.simple.basic.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

@Mapper //마이바티스 매퍼를 지칭 ( 스프링에선 생략가능 ) 
public interface TestMapper {

	public String getTime(); //1
	public ArrayList<ScoreVO> getScore(); //1-1
	public ScoreVO getOne(int a); //한 행에 대한 조회
	public int insertOne(String name); //단일값
	public int insertTwo(ScoreVO vo); //다중값
	public int insertThree(Map<String,String> map); //다중값
	
	public Map<String, Object> selectMap(int num); //3번 키값 조회(단일값)
	public ArrayList<Map<String, Object>> selectTwo(); //맵을 통한 다중 조회
	
	//update 는 int void, boolean 다 상관없음
	public boolean updateOne(ScoreVO vo); // 6번 update
	
	public void insertFour(@Param("aaa")String name, @Param("bbb") int kor);
}
