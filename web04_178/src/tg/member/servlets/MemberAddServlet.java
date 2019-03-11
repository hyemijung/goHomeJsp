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
		
		String str = req.getParameter("google");
		System.out.println("doGet 정보 가져옴" + str);
		
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
		System.out.println("MemberAddServlet의 doPost를 한다");
		
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

			pstmt = conn.prepareStatement(sql); //문장을 준비만 한것-+sql을 전체를 넣어서
			
			pstmt.setString(1,  emailStr); // 물음표에 대한 설정(물음표도 순서가 있다)
			pstmt.setString(2,  pwdStr);	// 동적으로 입력
			pstmt.setString(3,  nameStr);
			
			
			pstmt.executeUpdate(); // 수행 // insert, delete 같은 수정을 한다
			

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
			
			
			out.println(htmlStr); // 사용자가 보기를 원하는 내용을 println으로

			
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