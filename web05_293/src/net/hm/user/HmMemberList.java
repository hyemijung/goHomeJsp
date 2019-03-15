package net.hm.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tg.member.MemberDto;

@WebServlet(value = "/hmMyUser/list") // /hmMyUser/list ( hmMyUser 앞에 / 표시는 절대경로를 의미하는 것이 아니라, 루트부터 찾아간다는 의미- 프로젝트
										// web05_280 을 더이상 벗어날수 없다)
public class HmMemberList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";

		String sql = "";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "SELECT MNO, MNAME, EMAIL, PWD, CRE_DATE, MOD_DATE";
			sql += " FROM MEMBERS";
			sql += " ORDER BY MNO DESC";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			System.out.println("쿼리 수행 성공");

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

//			request 회원 목록 데이터 보관
//			왜 리스트로 만들었나? 멤버가 몇 명이나 될지 모르는 것(여러명이라 ArrayList 로 만들었다)
			ArrayList<MemberDto> memberList = new ArrayList<MemberDto>(); // 이후 memberListView.jsp 로 전달한다

			int mno = 0;
			String mname = "";
			String email = "";
			Date creDate = null;
			String pwd = "";
			Date modDate = null;

//			데이터베이스에서 회원 정보를 가져와 MemberDto에 담는다
//			그리고 MemberDto 객체를 ArrayList에 추가한다
			while (rs.next()) {
				mno = rs.getInt("MNO"); // 데이터베이스에 있는 컬럼명과 순서를 맞춰줘야 한다!
				mname = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				pwd = rs.getString("PWD");
				creDate = rs.getDate("CRE_DATE");
				modDate = rs.getDate("MOD_DATE");

//				눈 여겨 보자!!
				MemberDto memberDto =
						new MemberDto(mno, mname, email, pwd, creDate, modDate);
				memberList.add(memberDto);

			} // while end

			// request에 회원 목록 데이터를 보관한다 // map 방식
			req.setAttribute("memberList", memberList);

			// jsp로 출력을 위임한다(페이지를 넘긴다) //리퀘스트를 풀다
			RequestDispatcher dispatcher = req.getRequestDispatcher("/hmMyUser/hmMemberListView.jsp"); // 다음 경로의 위치 설정

			dispatcher.include(req, res); // setAttribute로 담았으니깐 가져가야 페이지의 내용이 소실되지 않는다

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();

			// 예외처리 페이지로 위엄
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");

			dispatcher.forward(req, res); // forwarding 방식(다른페이지로 위임하는 방식)

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if(rs != null) end

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}
}
