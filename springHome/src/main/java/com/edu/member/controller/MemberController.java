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

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	// class는 적으면 안되서 비슷한 clazz를 써놓음

	@Autowired
	private MemberService memberService;
	// 인스턴스 변수
	// 모든 메서드에서 다룰 수 잇음
	// 절대 지워지지 않는 특징을 가짐
	// 여기서 일처리를 하겠다는 하나의 선언?

	// 회원목록 조회 화면으로
	@RequestMapping(value = "/member/list.do", method = RequestMethod.GET)
	public String memberList(Model model) {
		// 간혹가다 getMembers 이런식으로 메서드명 지정하는 곳도 있음(getter/setter)
		// memberListByNo, memberListByMno 이런식으로
		// 프로젝트의 발전가능성을 멀리 본다면 신중히 작성해야함?
		// 여기도 인터페이스 implement 받는경우도 있음
		// request의 기능을 model이 대신해줌. 쓸순있지만 자동으로 구현된거나 마찬가지라 안씀
		// model은 스프링이 준비해준 객체임(?)
		// 컨트롤러는 무조건 service에 정보를 넘겨줌
		log.info("Welcome MemberController enter! ");
		List<MemberVo> memberList = memberService.memberSelectList();

		model.addAttribute("memberList", memberList);
		// 데이터를 담아 전달할 것이 없어서 session안쓰고 model 씀??

		return "member/memberListView";
		// JUnit테스트 가능!
	}

	// 다양한 방법을 보여주기 위해 이상한(?) 짓 하는중.......?!?!?!?!?!!
	@RequestMapping(value = "/auth/login.do", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		log.debug("Welcome MemberController enter! ");
		// syso와 같은 역할

		return "auth/loginForm";
	}

	// 다양한 방법을 보여주기 위해 이상한(?) 짓 하는중.......?!?!?!?!?!!
	// map방식은 이런식으로 합니당 //value = 메서드의 시작 주소
	@RequestMapping(value = "/auth/loginCtr.do", method = RequestMethod.POST)
	// input 태그에서 받아온 값(name=email,password)들을 매개변수로 던져 받아옴
	public String loginCtr(String email, String password, HttpSession session, Model model) {
		// Model은 미래를 위해 만들어놓음
		// 지금은 홈으로 넘어가는거지만 앞으로는..!
		// 데이터를 그대로 다른 페이지로 전송하는 역할
		// request의 역할을 하고있음
		log.debug("Welcome MemberController enter! " + email + ", " + password);
		// syso와 같은 역할

		// 회사레벨에선 무조건 object임 나에게 맞춰 가변적으로 변화시키기위해서 object로..>!
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("pwd", password);
		// 2번째로 작성

		MemberVo memberVo = memberService.memberExist(paramMap); // <---f3말고 ctrl + 커서올리면
		// 여길 먼저 작성

		String viewUrl = "";

		if (memberVo != null) {
			// 회원이 존재한다면 세션에 담고
			// 회원 전체 조회 페이지로 이동
			session.setAttribute("_memberVo_", memberVo);
			// 세션을 연속?두번이상 setAttribute한다면 덮어씌워짐

			viewUrl = "redirect:/member/list.do";// 데이터파기 + 세션 유지
			// sendRedirect를 사용하는 방식 = redirect:
			// 돈(결제)과 관련된거였으면 바로 jsp로 보냄.
		} else {
			System.out.println("일단 안되는 걸로 치자");

//			viewUrl = "home";
			viewUrl = "/auth/loginFail";
		}

//		model.addAttribute("memberVo", memberVo); 
//		세션에 담는 redirect형태가 되었으니 필요가 없음

		// 앞에선 가져올 수 없었던 새로운 데이터를 다른 페이지로 전송!앞의 맥락과 일치
		// 모델에 데이터베이스를 직접 넣지는 않음?
		return viewUrl;
	}
	// 홈으로 일단 전달해보기
	// memberListView로 보내면 안됨!
	
	
	
	@RequestMapping(value = "/auth/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		log.debug("Welcome MemberController enter!  logout 페이지로 이동 !");
		
		//세션의 객체들 파기
		session.invalidate();
		
		
		return "auth/loginForm";
	}
	@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
	public String memberAdd(HttpSession session, Model model) {
		log.debug("Welcome MemberController enter!  memberAdd 페이지로 이동 !");
		
		
		return "member/memberForm";
	}
	
	
	
	@RequestMapping(value = "/member/addCtr.do",
			method = RequestMethod.POST)
	public String memberAdd(MemberVo memberVo, Model model) {
		log.debug("Welcome MemberController enter!  memberAdd ! 신규등록 처리!"
	+memberVo);
		
		memberService.memberInsertOne(memberVo);
		
		
		return "redirect:/member/list.do";
	}

	
	
	@RequestMapping(value = "/member/listOne.do", method = RequestMethod.GET)
	public String memberListOne(int no, Model model) {

		log.info("Welcome MemberController enter! -{}",  no);
		// c언어방식의 printF.... 블럭표시 하고 no 적으면 블럭 안에 no가 들어감!
		System.out.printf("{} 첫번째와 두번째에 변수 넣을수있음{}", "something","behind");
		
		MemberVo memberVo = memberService.memberSelectOne(no);
		//int하나를 전달한다고 memberSelectOne에 객체를(memberVo타입) 전달하는건 비효율적
		//하나만 뽑아쓰기 가능
		
		model.addAttribute("memberVo", memberVo);
		// 데이터를 담아 전달할 것이 없어서 session안쓰고 model 씀??
		//request 대신 쓰는듯. 어떤페이지로도 보낼 수 있음
		//데이터를 담아 전달해야되서 model 씁니다,,,허헛,,흐히,,
		//덕분에 형변환도 안해도 됩니다...!
		
		return "member/memberListOneView";
	}
	
	
	//meethod를 안써주면 자동적으로 post와 get을 결정해줌
	@RequestMapping(value = "/member/update.do", method = RequestMethod.GET)
	public String memberUpdate(int no, Model model) {

		log.info("Welcome MemberController enter! -{}" + no);

		MemberVo memberVo = memberService.memberSelectOne(no);
		//기능의 분리! listOne메서드랑 같은거 갖고옴 ㅎ
		
		model.addAttribute("memberVo", memberVo);
		// 데이터를 담아 전달할 것이 없어서 session안쓰고 model 씀??

		return "member/memberUpdateForm";
	}
	
	
	@RequestMapping(value = "/member/updateCtr.do", method = RequestMethod.POST)
	public String memberUpdateCtr(HttpSession session, MemberVo memberVo, Model model) {
		log.debug("Welcome MemberController enter!  memberAdd ! 신규등록 처리!"
				+memberVo);
		
		int resultNum = memberService.memberUpdateOne(memberVo);
		// 누군가 한명이라도 수정한다면 resultNum은 1 이상이 된다
		// 아무도 수정하지않았다면 resultNum 은 0 이다.
		
//		System.out.println("???????????" + resultNum);
		
		// 데이터베이스에서 회원정보가 수정이 됐는지 여부
		if (resultNum > 0) {
			
			MemberVo sessionMemberVo = 
					(MemberVo)session.getAttribute("_memberVo_");
			// 속성을 가져오면 맵의 특징을 가져오게 되는 것이다
			
			// 세션에 객체가 존재하는지 여부			
			if (sessionMemberVo != null) { // 비회원 상태에서도 수정이 가능해버림;;
				// 세션의 값과 새로운 값이 일치하는지 여부!!
				// 홍길동				새로운 사람
				// s1@test.com		새로운@
				// 1111				222
				// 변화전과 후의 사람이 같은 사람임을 입증하는 무언가 필요하다! 
				// -> 사용자가 변경할수 없고 절대로 변하지 않는 기본키!!!!!!
				if (sessionMemberVo.getNo() == memberVo.getNo()) { 
					// 원래는 데이터베이스에서 제대로 가져와야한다 -> 위와같이하면 위험해진다(데이터베이스의 힘을 빌려야 이를 방지할수 있다)
					//그래서 변화전과 변화후의 기본키가 일치되는지를 보는 것 
					// 예전껀 sessionMemberVo, 수정된것은 memberVo
					
					MemberVo newMemberVo = new MemberVo();
					
					newMemberVo.setNo(memberVo.getNo());
					newMemberVo.setEmail(memberVo.getEmail());
					newMemberVo.setName(memberVo.getName());
					
		// 세션을 종료하려면, 로그아웃 같은 이벤트를 일으키커나 브라우저를 종료하지 않는한 유지된다
					session.removeAttribute("_memberVo_");
					
					session.setAttribute("_memberVo_", newMemberVo);
					
//	[강사님 의도]
//		왜 new했는가?
//		new하면 하나도 정보가 없는 깨끗한 MemberVo
//		* 기존의 것이 남아있으면 데이터베이스와 불균형이 있을수 있다 -> removeAttribute
//		* 그냥 MemberVo를 setAttribute한다면 -> 사용자가 넣은 정보가 모두들어있다 (비밀번호까지)
//		* 그래서 필요한 부분만(No, Email, Name) 새로운 객체를 생성한 newMemberVo에 set하여 준다
				}
			}
		}
		
		
		
		return "common/successPage";
	}
	
	
	
	
}
