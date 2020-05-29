package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.board.service.BoardService;

@Controller
public class IndexController {
	@Autowired
	BoardService boardService;
	
	
}
