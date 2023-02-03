package com.simple.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/request") //메서드 앞에 공통으로 들어가는 요청경로
public class RequestController {

//	String메서드 - 출력 화면을 직접 지정
//	//@RequestMapping는 클래스에 올릴수 있다.
//	@RequestMapping("/ex01")   //url 요청경로 (클래스위에 요청경로 적어주면 똑같은거 두번 써주지 않아도 된다.)
//	public String ex01() {
//		return "request/ex01";   //화면에 출력경로
//	}
	//void메서드 : 요청경로가 출력경로가 된다.
	@RequestMapping("/ex01")
	public void ex01 () {
		
	}
	
	//get만 허용
	//@RequestMapping(value="/basic1", method = RequestMethod.GET)
	@GetMapping("/basic1")
	public String basic1() {
		System.out.println("get만 허용");
		return null;
	}
	//post만 허용
	//@RequestMapping(value="/basic2", method=RequestMethod.POST)
	@PostMapping("/baisc2")
	public String basic2() {
		System.out.println("POST만 허용");
		return null;
	}
	
	// get, post 둘다 허용
	@RequestMapping("/basic3")
	public String basic3() {
		System.out.println("get,post 둘다 허용");
		return null;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	//ex02 화면 //////////////////////////////////
	@RequestMapping("/ex02")
	public String ex02() {
		return "request/ex02";
	}
	
	
//	1번째 방법
//	@RequestMapping(value="/doAction", method=RequestMethod.POST)
//			public String doAction(HttpServletRequest request) {
//			//name 파람
//			String name = request.getParameter("name");
//			//age 파람
//			String age = request.getParameter("age");
//			//inter - checkbox
//			String[] inter = request.getParameterValues("inter");
//			
//			System.out.println(name);
//			System.out.println(age);
//			System.out.println(Arrays.toString(inter));
//		return "request/ex02_ok";
//	}

	
	// 2번째 방법	
//	@RequestMapping("/doAction")
//	public String doAction(@RequestParam(value="name", required=false, defaultValue = "") String name,
//							@RequestParam("age") int age,
//							@RequestParam(value="inter", required = false, defaultValue = "")List<String>list) {
//		//requestParam은 공백과 null데이터가 전달되면 요청을 거절하게 된다.
//		//필수가 아닌 파라미터는 required=false 속성을 지정하면 된다.
//		//필수가 아닌 파라미터인 경우에는 null or ""을 지정하게 되는데 defaultValue으로 기본값을 줄 수 있습니다.
//	
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(list.toString());
//		return "request/ex02_ok";
//	}
	
	// 3번째 방법 - 커맨드 객체를 통해서 맵핑( 넘어오는 데이터 name과 setter명이 같아햐한다.)
		@RequestMapping("/doAction")
		public String doAction(ReqVO vo) {
			
			System.out.println(vo.toString());
			return "Request/ex02_ok";
		}
	/////////////////////////////////////////////////
		@RequestMapping(value="/login", method=RequestMethod.POST)
		public String login(@RequestParam("id") String id,
							@RequestParam("pw") String pw) {
			
			
			if(id.equals("abc123")&&pw.equals("xxx123")) {
				return "request/req_quiz01_ok";
			}else {
				return "request/req_quiz01_no";
			}
		}
		//화면처리
		@RequestMapping("/req_quiz01")
		public String quiz01() {
			return "request/req_quiz01";
		}
	
		
		
}
