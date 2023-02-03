package com.simple.basic;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //1
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //2 동작시킬 스프링 설정파일
public class JDBCTest {

//	@BeforeClass //해당 클래스에서 단 한번 실행 - static
//	public static void loadTest() {
//		System.out.println("beforeClass");
//	}
//	
//	@Before//5  before는 각 테스트 코드를 실행하기 전에 우선실행되는 것. 
//	public void testCode00() {
//		System.out.println("before");
//	}
	
	//root-context.xml에 잘 들어갔는지 Autowired 해보기
	@Autowired //6
	DataSource dataSource; //javax.sql.DataSource //5
	
	
	@Test //4 test코드로 실행함
	public void testCode01() { //3
//		System.out.println("실행됨1"); //JUnit실행
		try {  //7
			//DataSource에서 conn객체 얻음
			Connection conn  = dataSource.getConnection();			
		} catch (Exception e) {
		}
	}
	

}
