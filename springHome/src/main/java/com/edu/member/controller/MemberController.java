package com.edu.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.member.service.MemberService;
import com.edu.member.vo.MemberVo;

@Controller
public class MemberController {

	private static final Logger log = 
			LoggerFactory.getLogger(MemberController.class); // 이 형태까지 만들어서 이클립스에 올려야함(팀장이 설계)
			
	@Autowired
	private MemberService memberService;
	
	// 회원 목록 조회 화면으로
	@RequestMapping(value="/member/list.do", method=RequestMethod.GET)
	public String memberList(Model model) {
	
		log.debug("Welcome MemberController enter! ");
//		log.debug("msg");
//		log.trace("msg");
		
		List<MemberVo> memberList = memberService.memberSelectList();
		
		model.addAttribute("memberList", memberList); //jsp값이 필요하면 모델에 담아라
		
		return "member/memberListView";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(Model model) {
		log.debug("Welcome MemberController login 페이지 이동!");
		
		return "auth/loginForm";
	}
	
	
	@RequestMapping(value="/loginCtr.do", method=RequestMethod.POST)
	public String loginCtr(String email, String password, Model model) {
		log.debug("Welcome MemberController login 페이지 이동!" + email + ", " + password);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("pwd", password);
		
		MemberVo memberVo = memberService.memberExist(paramMap);
		
		model.addAttribute("memberVo", memberVo);
		
		return "home";
	}
	
	
}
