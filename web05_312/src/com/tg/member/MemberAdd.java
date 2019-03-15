package com.tg.member;

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

@WebServlet(value = "/member/add")
public class MemberAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.sendRedirect("./memberForm.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";

//		req.setCharacterEncoding("UTF-8"); // -> web.xml 에서 관리가됨

		String emailStr = req.getParameter("email"); // 한글깨지지 않는 셋팅하고 한글 넣고싶으면 넣어라
		String pwdStr = req.getParameter("password");
		String nameStr = req.getParameter("name");

		String sql = "";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "INSERT INTO MEMBERS";
			sql += " (MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)";
			sql += " VALUES(MEMBERS_MNO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE)";

			pstmt = conn.prepareStatement(sql); // 문장을 준비만 한것-+sql을 전체를 넣어서

			pstmt.setString(1, emailStr); // 물음표에 대한 설정(물음표도 순서가 있다)
			pstmt.setString(2, pwdStr); // 동적으로 입력
			pstmt.setString(3, nameStr);

			pstmt.executeUpdate(); // 수행 // insert, delete 같은 수정을 한다

//			추가 - 새로고침할때마다 다시 남아있는 이전 양식의 수행을 막으려면?
			res.sendRedirect("./list"); // 새 정보를 추가하고나서 ./list 경로를 던져서 - 상대경로를 찾아간다
										// 새로고침해도 양식이 다시 입력되지않고 상대경로로 찾아간다

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if(rs != null) end

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end

	}
}
