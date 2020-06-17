package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.board.dto.MemberVO;
import com.board.service.BoardService;
import com.board.service.MemberService;

@Controller
@SessionAttributes("loginMember")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/login")
	public String login(Model model) {
		boolean login = true;
		model.addAttribute("isLogin", login);
		model.addAttribute("boardList", boardService.getAllBoradList());
		return "index";
	}
	@PostMapping("/join")
	public String join(MemberVO memberVO) {
		memberService.join(memberVO);
		return "redirect:/login";
	}
	@GetMapping("/login_success")
	public String login_success(@AuthenticationPrincipal User user,Model model) {
		MemberVO memberVO = memberService.findOne(user.getUsername());
		System.out.println("LoginSuccess");
		model.addAttribute("loginMember", memberVO);
		return "redirect:/";
	}
	@GetMapping("/login_fail")
	public String login_fail(Model model) {
		model.addAttribute("isLogin",true);
		model.addAttribute("message","Login Fail");
		return "index";
	}
}
