package tg.member.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("MemberAddServlet의 doGet을 한다");

		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");

		PrintWriter out = res.getWriter();

		String htmlStr = "";

		htmlStr += "<!DOCTYPE html>";
		htmlStr += "<html>";
		htmlStr += "<head>";
		htmlStr += "<meta charset='UTF-8'>";

		htmlStr += "<title>회원 등록</title>";
		htmlStr += "</head>";
		htmlStr += "<body>";

		htmlStr += "<h1>회원등록</h1>";
		htmlStr += "<form action='add' method='post'>";
		htmlStr += "이름: <input type='text' name='name'></br>";
		htmlStr += "이메일: <input type='text' name='email'><br>";
		htmlStr += "암호: <input type='password' name='password'><br>";

		htmlStr += "<input type='submit' value=추가>";
		htmlStr += "<input type='reset' value='취소'>";

		htmlStr += "</form>";

		out.println(htmlStr);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = " jsp";

		String emailStr = req.getParameter("email");
		String pwdStr = req.getParameter("password");
		String nameStr = req.getParameter("name");

		String sql = "";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "INSERT INTO MEMBERS";
			sql += "(MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)";
			sql += "VALUES(MEMBERS_MNO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE)";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  emailStr);
			pstmt.setString(2,  pwdStr);
			pstmt.setString(3,  nameStr);
			
			
			pstmt.executeUpdate();
			

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			PrintWriter out = res.getWriter();

			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");

			// 새로 추가
			String htmlStr = "";
			
			

			htmlStr += "<!DOCTYPE html>";
			htmlStr += "<html>";
			htmlStr += "<head>";
			htmlStr += "<meta charset=\"UTF-8\">";
			htmlStr += "<title>회원등록결과</title>";
			htmlStr += "</head>";
			htmlStr += "<body>";
			htmlStr += "<p>등록 성공입니다~!</p>";
			
			
			out.println(htmlStr);

			
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

}