package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.dto.BoardKind;
import com.board.dto.BoardVO;
import com.board.service.BoardService;

import utils.CriteriaVO;
import utils.PageMaker;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String index(Model model) {
		CriteriaVO cri = new CriteriaVO();
		int totalCount = boardService.getTotalRecord();
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("boardList", boardService.getPagingBoardList(cri));
		return "index";
	}
	@PostMapping("/board/save")
	public String save(BoardVO boardVO,@RequestParam int b_kind2) {
		boardVO.setB_kind(BoardKind.valueOf(b_kind2));
		boardService.save(boardVO);
		return "redirect:/";
	}
	@PostMapping("/board/delete")
	public String delete(@RequestParam int b_code) {
		boardService.delete(b_code);
		return null;
	}
	@GetMapping("/board/list") 
	public String list(@RequestParam int page,Model model) {
		CriteriaVO cri = new CriteriaVO();
		cri.setPage(page);
		int totalCount = boardService.getTotalRecord();
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("boardList", boardService.getPagingBoardList(cri));
		return "index";
	}
	@GetMapping("/board/findOne")
	public String findOne(Model model, @RequestParam int b_code) {
		model.addAttribute("boardVO", boardService.findOne(b_code));
		return "freeboard/viewboard";
	}
	@GetMapping("/board/write")
	public String write_form() {
		return "freeboard/writeboard";
	}


}
