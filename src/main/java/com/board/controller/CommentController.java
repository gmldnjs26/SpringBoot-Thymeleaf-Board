package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.dto.CommentVO;
import com.board.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comment/insert")
	public String insert(CommentVO commentVO,RedirectAttributes redirectAttrs) {
		commentService.insert(commentVO);
		redirectAttrs.addAttribute("b_code", commentVO.getB_code());
		return "redirect:/board/findOne";
	}
	
	@PostMapping("/comment/delete")
	public String delete(@RequestParam int c_code,@RequestParam int b_code,RedirectAttributes redirectAttrs) {
		commentService.delete(c_code);
		redirectAttrs.addAttribute("b_code",b_code);
		return "redirect:/board/findOne";
	}
	
	
}
