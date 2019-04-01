package com.edu.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="/auth/login.do", method=RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		log.debug("Welcome MemberController login 페이지 이동!");
		
		return "auth/loginForm";
	}
	
	// 맵방식으로 선언하는 방식
//	@RequestMapping(value="/auth/loginCtr.do", method=RequestMethod.POST)
//	public String loginCtr(String email, String password, HttpSession session, Model model) {
//		log.debug("Welcome MemberController login 페이지 이동!"
//				+ email + ", " + password);
//		
//		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("email", email);
//		paramMap.put("pwd", password);
//		
//		MemberVo memberVo = memberService.memberExist(paramMap);
//		
//		String viewUrl = "";
//		if (memberVo != null) {
//			// 회원이 존재한다면 세션에 담고
//			// 회원 전체 조회 페이지로 이동
//			session.setAttribute("_memberVo_", memberVo);
//			
//			viewUrl = "redirect:/member/list.do";
//		} else {
////			System.out.println("일단 안되는걸로 치자 ");
//			//1 강사님
//			memberVo = new MemberVo();
//			memberVo.setEmail(email);
//			memberVo.setPassword(password);
//			model.addAttribute("email", memberVo);
//			viewUrl = "/auth/loginFail";
//			//2 강사님 (map 방식)
////			model.addAttribute("email", email);
////			model.addAttribute("password", password);
//			//3(기성씨) // (el태그 사용시 맵은 키의 키를 찾는다)
////		model.addAttribute("paramMap", paramMap);			
////			viewUrl = "home";
//		}
//		
////		model.addAttribute("memberVo", memberVo);
//		
//		return viewUrl;
//	}
	
	// 위와 달리 맵방식이 아닌 vo객체를 매개변수로 선언해서 하는 방식
	//맵방식으로 하다보면 매개변수를 일일히 입력할때 실수가 발생할수가 있다
	// -> 그럴때 vo객체를 이용하면 데이터를 가공처리할 필요가 없기때문에 좋다
	@RequestMapping(value="/auth/loginCtr.do", method=RequestMethod.POST)
	public String loginCtr(MemberVo paramMemberVo, 
			HttpSession session, Model model) {
		log.debug("Welcome MemberController login 페이지 이동!"
				+ paramMemberVo);
		
		MemberVo memberVo = memberService.memberExist1(paramMemberVo);
		
		String viewUrl = "";
		if (memberVo != null) {
			// 회원이 존재한다면 세션에 담고
			// 회원 전체 조회 페이지로 이동
			session.setAttribute("_memberVo_", memberVo);
			
			viewUrl = "redirect:/member/list.do";
		} else {
//			System.out.println("일단 안되는걸로 치자 ");
			//1 강사님
//			memberVo = new MemberVo();
//			memberVo.setEmail(email);
//			memberVo.setPassword(password);
			model.addAttribute("email", memberVo);
			viewUrl = "/auth/loginFail";
			//2 강사님 (map 방식)
//			model.addAttribute("email", email);
//			model.addAttribute("password", password);
			//3(기성씨) // (el태그 사용시 맵은 키의 키를 찾는다)
//		model.addAttribute("paramMap", paramMap);			
//			viewUrl = "home";

		}
		
		return viewUrl;
	}
	
	@RequestMapping(value="/member/add.do", method=RequestMethod.GET)
	public String memberAdd(Model model) {
		log.debug("Welcome MemberController memberAdd 페이지 이동!");
		
				
		return "member/memberForm";
	}
	
	@RequestMapping(value="/member/addCtr.do", 
			method=RequestMethod.POST)
	public String memberAdd(MemberVo memberVo, Model model) {
		log.debug("Welcome MemberController memberAdd 신규등록 처리!"
				+ memberVo);
		
		memberService.memberInsertOne(memberVo);
		
		return "redirect:/member/list.do";
	}
	
}
