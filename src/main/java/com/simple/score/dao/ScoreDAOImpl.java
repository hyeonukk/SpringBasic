package com.simple.score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy")
public class ScoreDAOImpl implements ScoreDAO {

	//1
	@Autowired
	private DataSource dataSource;
	
	
	
	@Override
	public void regist(ScoreVO vo) {
		
		String sql = "insert into score(name, kor, eng) values(?,?,?)";
		//6
		Connection conn = null; //2 db연결
		PreparedStatement pstmt = null; //3
		
		try {
		conn =dataSource.getConnection(); //4 
		pstmt = conn.prepareStatement(sql); //5

		pstmt.setString(1, vo.getName()); //6
		pstmt.setString(2, vo.getKor()); //6
		pstmt.setString(3, vo.getEng()); //6

		pstmt.executeLargeUpdate();   //insert , update, delete
		} catch (Exception e) {
			e.printStackTrace(); //7
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt !=null) pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	

	@Override
	public ArrayList<ScoreVO> getList() {
		
		ArrayList<ScoreVO> list = new ArrayList<>(); //7
		
		String sql ="select * from score order by num desc"; //1
		
		Connection conn = null ; //2
		PreparedStatement pstmt = null; //3
		ResultSet rs = null; 
		
		try {
			conn = dataSource.getConnection(); //4
			pstmt = conn.prepareStatement(sql); //5 sql
			rs = pstmt.executeQuery(); //6 결과 출력
			
			//orm
			while(rs.next()) {
				//8
				ScoreVO vo = new ScoreVO();
				vo.setNum(rs.getInt("num")); //num값 담아주기
				vo.setName(rs.getString("name")); 
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));
				
				list.add(vo); // 9 . list에 담아주기
			}
		} catch (Exception e) {
			e.printStackTrace(); //10
		}  finally { //11
			try { //12
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
			
			}
		}
		
		return list;
	}

	@Override
	public void delete(int num) {
		//삭제기능 - num은 key가 아니라 index가 넘어온다(화면에서 key를 넘기도록 변경
		
		
		
		String sql = "delete from score where num =? ";
		
		Connection conn = null; 
		PreparedStatement pstmt = null; 

		
		try {
			conn = dataSource.getConnection(); //데이터얻어오기
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setInt(1, num);
			pstmt.executeLargeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt !=null) pstmt.close();
				
			} catch (Exception e2) {
			
			
			}
		}
	}

	
	
	
//	//데이터베이스
//	ArrayList<ScoreVO> list = new ArrayList<>();
//	
//	@Override
//	public void regist(ScoreVO vo) {
//		//System.out.println("DAO영역:" + vo.toString());
//		
//		
//		list.add(vo); //insert임
//		System.out.println(list.toString());
//	}
//
//	@Override
//	public ArrayList<ScoreVO> getList() {
//		//데이터조회...
//		return list;
//	}
//
//	@Override
//	public void delete(int num) {
//		list.remove(num);
//	}

}






