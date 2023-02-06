package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.board.service.BoardService;
import com.simple.command.BoardVO;


@Controller
@RequestMapping("/service")
public class BoardController {

	@Autowired
	@Qualifier("zzz")
	private BoardService board;
	
	
	//화면출력
		@RequestMapping("/boardRegister")
		public String registView() {
			return "service/boardRegister";
		}
		
		//폼요청
		@RequestMapping(value="/regist", method=RequestMethod.POST)
		public String regist(BoardVO vo) {
			
			board.regist(vo);
			
			return "service/boardResult";
		}
		
		@RequestMapping("/boardList")
		public String list(Model model) {
			ArrayList<BoardVO> list = board.getList();
			model.addAttribute("list", list);
			return "service/boardList";
		}
		
		
		
}
