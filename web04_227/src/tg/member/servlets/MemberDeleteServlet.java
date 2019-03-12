package tg.member.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/member/delete")

public class MemberDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub


		Connection conn = null;
		PreparedStatement pstmt = null;
				
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		int mNo = Integer.parseInt(req.getParameter("mNo"));
		
		String sql = "";
		
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드");
			
			conn = DriverManager.getConnection(url, user, password);
						
			sql = "DELETE FROM MEMBERS";
			sql += " WHERE MNO = ?";
						
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mNo);
			
			pstmt.executeUpdate();
			
			res.sendRedirect("./list");
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
						
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally 종료
		
	}
		
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MemberUpdateServlet의 doPost를 한다");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 결과값을 받아서 하는것이 아니므로 필요없어서, rs= reSuelt 없어도 됨

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = " jsp";
		
		req.setCharacterEncoding("UTF-8"); // 한글이 깨지지않도록 셋팅하는 것!!!
		

		String email = req.getParameter("email"); // 한글깨지지 않는 셋팅하고 한글 넣고싶으면 넣어라
		String name = req.getParameter("name");
		int mNo = Integer.parseInt(req.getParameter("mNo"));
				
		String sql = "";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "UPDATE MEMBERS";
			sql += " SET EMAIL = ?, MNAME = ?, MOD_DATE = SYSDATE";
			sql += " WHERE MNO = ?"; 		//기본키를 사용했으므로 이것을 무언가 수정할때 mNo만 넘기면 된다
			
			pstmt = conn.prepareStatement(sql); //문장을 준비만 한것-+sql을 전체를 넣어서
			
			pstmt.setString(1,  email); // 물음표에 대한 설정(물음표도 순서가 있다)
			pstmt.setString(2,  name);	// 동적으로 입력
			pstmt.setInt(3,  mNo);
					
			pstmt.executeUpdate(); // 수행 // insert, delete 같은 수정을 한다
			
//			추가 - 새로고침할때마다 다시 남아있는 이전 양식의 수행을 막으려면?
			res.sendRedirect("./list"); // 새 정보를 추가하고나서 ./list 경로를 던져서 - 상대경로를 찾아간다 
										// 새로고침해도 양식이 다시 입력되지않고 상대경로로 찾아간다
			
			
			// 아래처럼하면 페이지를 보여주므로 사용자가 새로고침을 하면 다시 또 실행이될수있는것 !!
			// printWrither의 문제점
			// select이 아님 입력하는 형식이 여기있으면 큰일날수 있음

//			res.setContentType("text/html"); 
//			res.setCharacterEncoding("UTF-8");
//
//			PrintWriter out = res.getWriter();
//
//			out.println("<html><head><title>회원목록</title></head>");
//			out.println("<body><h1>회원목록</h1>");
//
//			// 새로 추가
//			String htmlStr = "";
//			
//			
//
//			htmlStr += "<!DOCTYPE html>";
//			htmlStr += "<html>";
//			htmlStr += "<head>";
//			htmlStr += "<meta charset=\"UTF-8\">";
//			htmlStr += "<title>회원등록결과</title>";
//			htmlStr += "</head>";
//			htmlStr += "<body>";
//			htmlStr += "<p>등록 성공입니다~!</p>";
	
			
//			out.println(htmlStr); // 사용자가 보기를 원하는 내용을 println으로

			
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