package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.domain.BoardVO;
import com.green.domain.CriteriaVO;
import com.green.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board/*")
@Slf4j
@AllArgsConstructor
public class BoardController {

	   private BoardService service;
	   
	   @GetMapping("/list")
	   public void list(Model model, CriteriaVO cri) {
	      model.addAttribute("list", service.getList(cri));
	      System.out.println(service.getList(cri));
	      System.out.println("값가져옴");
	   }
	   
	   @PostMapping("/register")
	   public String register(BoardVO board, RedirectAttributes rttr) {
		  
		   
		   service.register(board);
		   
		   rttr.addFlashAttribute("result", board.getBno());
		   log.info("register : " + board);
		   
		   return "redirect:/board/list";
	   }
	   
	   @GetMapping("/register")
	   public String register() {
		   
		   
		   return "/board/register";
	   }
	   
	   @GetMapping({"/get","/modify"})
//	   @GetMapping("/get")
	   public void get(@RequestParam("bno") Long bno, Model model) {
		   model.addAttribute("board", service.get(bno));
		   System.out.println(service.get(bno));
		   System.out.println("get");
	   }
	   
	   @PostMapping("/modify")
	   public String modify(BoardVO board, RedirectAttributes rttr) {
		   log.info("modify : " + board);
		   log.info("modify에서의 getContent : " + board.getContent());
		   
		   if(service.modify(board)) {
			   rttr.addFlashAttribute("result", "success");
		   }
		   return "redirect:/board/list";
	   }
	   
	   @PostMapping("/remove")
	   public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		   log.info("remove..." + bno);
		   if(service.remove(bno)) {
			   rttr.addFlashAttribute("result", "success");
		   }
		   return "redirect:/board/list";
	   }
	
}
