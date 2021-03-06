package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.spring.domain.WriteDTO;
import com.lec.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;

	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	public BoardController() {
		System.out.println("BoardController() 생성");
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		model.addAttribute("list", boardService.list());
		
		return "board/list";
	}
	
	@GetMapping("/write.do")
	public String write(Model model) {
		return "board/write";
	}	
	
	@PostMapping("/writeOk.do")
	public String writeOk(WriteDTO dto, Model model) {
		
		model.addAttribute("result", boardService.write(dto));
		model.addAttribute("dto", dto);   // auto-generated key
		
		return "board/writeOk";
	}
	
	
	@GetMapping("/view.do")
	public String view(int uid, Model model) {
		
		model.addAttribute("list", boardService.viewByUid(uid));
		
		return "board/view";
	}
	
	@RequestMapping("/update.do")
	public String update(int uid, Model model) {
		
		model.addAttribute("list", boardService.selectByUid(uid));
		
		return "board/update";
	}
	
	@RequestMapping("/updateOk.do")
	public String updateOk(WriteDTO dto, Model model) {
		
		model.addAttribute("result", boardService.update(dto));
		
		return "board/updateOk";
	}
	
	@GetMapping("/deleteOk.do")
	public String deleteOk(int uid, Model model) {
		
		model.addAttribute("result", boardService.deleteByUid(uid));
		
		return "board/deleteOk";		
	}
	

}

















