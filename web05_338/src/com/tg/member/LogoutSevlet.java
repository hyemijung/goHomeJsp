package com.tg.member;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/auth/logout")
public class LogoutSevlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		doPost(req, res); //정보를 차단하기위해 doGet으로 와도 doPost로 다시보내 처리한다
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		// 세션 객체 호출
		HttpSession session = req.getSession();
		// 세션 객체 파기
		session.invalidate(); //setAttribute 한것을 모두 파기시킨다, null이 된것이 아님
		// 일정 시간이 지나면 자동적으로 파기한다 // 공인인증서같이 일정시간지나면, 마우스움직임 키보드입력이 하나도 없으면 사용되도록
//		session.setMaxInactiveInterval(60*60); // 초단위로 설정, (60*60)하면 한시간
		res.sendRedirect("./login");
		
		
	}
	
}
