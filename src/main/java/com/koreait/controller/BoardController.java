package com.koreait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;
import com.koreait.domain.PageDTO;
import com.koreait.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("------list------");
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(service.getTotal(cri),cri));
	}
	
	@GetMapping("/regist")
	public void regist(@ModelAttribute("cri")Criteria cri, Model model) {
//		model.addAttribute("cri",cri);
	}
	
	@PostMapping("/regist")
	public String regist(BoardDTO board,RedirectAttributes ra) {
		service.regist(board);
		//새롭게 등록한 게시글의 번호를 redirect로 같이 보내주려면
		//Model 대신에 RedirectAttributes 를 사용한다.
		ra.addFlashAttribute("wn",board.getBoardnum());
		
		//redirect: 접두어를 사용하게 되면 스프링 MVC가 자동으로 redirect로 처리해준다.
		return "redirect:/board/list";
	}
	//아래의 메소드는 /get이나 /modify인 경우에 호출되는데
	//그 때 호출하는 uri대로 view를 찾을 것이다.
	//즉 /get으로 요청해서 호출됐다면 get.jsp를, /modify로 요청해서 호출됐다면 modify.jsp를 찾게된다.
	@GetMapping({"/get","/modify"})
	public void get(Long boardnum, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.get(boardnum));
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO board, Criteria cri, RedirectAttributes ra) {
		if(service.modify(board)) {
			ra.addFlashAttribute("mn",board.getBoardnum());
		}
		return "redirect:/board/list"+cri.getListLink();
	}
	
	@PostMapping("/remove")
	public String remove(Long boardnum, Criteria cri, RedirectAttributes ra) {
		if(service.remove(boardnum)) {
			ra.addFlashAttribute("rn", boardnum);
		}
		return "redirect:/board/list"+cri.getListLink();
	}
}






